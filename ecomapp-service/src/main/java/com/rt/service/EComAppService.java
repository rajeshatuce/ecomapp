package com.rt.service;

import static com.rt.constant.EComAppConstant.CREATE_DATE;

import com.rt.constant.EComAppConstant.DeliveryStatus;
import com.rt.constant.EComAppConstant.OrderStatus;
import com.rt.constant.EComAppConstant.PaymentStatus;
import com.rt.constant.EComAppConstant.PaymentType;
import com.rt.constant.EComAppConstant.Status;
import com.rt.model.CustomerAddress;
import com.rt.model.CustomerQuery;
import com.rt.model.Order;
import com.rt.model.Product;
import com.rt.model.ProductCheckout;
import com.rt.model.ProductPicture;
import com.rt.model.ProductSelected;
import com.rt.repository.CustomerAddressRepository;
import com.rt.repository.CustomerQueryRepository;
import com.rt.repository.OrderRepository;
import com.rt.repository.ProductsRepository;
import com.rt.util.EcomAppServiceUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EComAppService {

  private final ProductsRepository productsRepository;
  private final EcomAppServiceUtil ecomAppServiceUtil;
  private final CustomerAddressRepository customerAddressRepository;
  private final OrderRepository orderRepository;
  private final CustomerQueryRepository customerQueryRepository;

  @Autowired
  public EComAppService(ProductsRepository productsRepository,
      EcomAppServiceUtil ecomAppServiceUtil, CustomerAddressRepository customerAddressRepository,
      OrderRepository orderRepository, CustomerQueryRepository customerQueryRepository) {
    this.productsRepository = productsRepository;
    this.ecomAppServiceUtil = ecomAppServiceUtil;
    this.customerAddressRepository = customerAddressRepository;
    this.orderRepository = orderRepository;
    this.customerQueryRepository = customerQueryRepository;
  }

  /**
   * Service to get active products from DB
   */
  public Map<String, List<Product>> getActiveProducts() {
    List<Product> products = productsRepository.findProductsByStatus(Status.Active.toString());
    return ecomAppServiceUtil.groupSimilarProductTogether(products);
  }

  /**
   * Service to prepare Order for selected products
   *
   * @param productsSelected for checkout
   * @param userEmailId who is selecting product
   * @return Order object
   */
  public Order getOrderForSelectedProducts(List<ProductSelected> productsSelected,
      String userEmailId) {
    Order order = new Order();
    List<ProductCheckout> productsOrdered = new ArrayList<>();

    for (ProductSelected productSelected : productsSelected) {
      Product product = productsRepository
          .findOne(productSelected.getProductId());//Get product from DB
      if (product != null && Status.Active.equals(product.getStatus())) {//If product active
        ProductCheckout productCheckout = new ProductCheckout();
        //set product basic details
        productCheckout.setProductId(product.getId());
        productCheckout.setCurrencyLabel(product.getCurrencyLabel());
        productCheckout.setCurrentUnitPrice(product.getCurrentUnitPrice());
        productCheckout.setName(product.getName());
        productCheckout.setSelectedQuantity(
            productSelected.getSelectedQuantity() > product.getMaxQuantityPerOrder() ? product
                .getMaxQuantityPerOrder() : productSelected.getSelectedQuantity());
        productCheckout.setPreviousUnitPrice(product.getPreviousUnitPrice());
        //set product thumbnail
        for (ProductPicture productPicture : product.getProductPictures()) {
          if (productPicture.isProductThumbNail()) {
            productCheckout.setUniqueFileName(productPicture.getUniqueFileName());
            break;
          }
        }
        //product specific calculation
        productCheckout.setSubTotal(ecomAppServiceUtil.roundToTwoDecimalPlaces(
            productCheckout.getCurrentUnitPrice() * productCheckout.getSelectedQuantity()));
        double previousPrice = ecomAppServiceUtil.roundToTwoDecimalPlaces(
            productCheckout.getPreviousUnitPrice() * productCheckout.getSelectedQuantity());
        productCheckout.setSavingsAmount(ecomAppServiceUtil
            .roundToTwoDecimalPlaces(previousPrice - productCheckout.getSubTotal()));
        productCheckout.setFormattedSavingsAmount(
            ecomAppServiceUtil.formatAmount(productCheckout.getSavingsAmount()));
        productCheckout
            .setFormattedSubTotal(ecomAppServiceUtil.formatAmount(productCheckout.getSubTotal()));
        order.setCurrencyLabel(product.getCurrencyLabel());
        order.setSubTotal(order.getSubTotal() + productCheckout.getSubTotal());
        order.setTotalSavings(order.getTotalSavings() + productCheckout.getSavingsAmount());
        productsOrdered.add(productCheckout);//add product for checkout
      }
    }
    order.setProductsOrdered(productsOrdered);//set products to order
    //calculate order sum
    order.setSubTotal(ecomAppServiceUtil.roundToTwoDecimalPlaces(order.getSubTotal()));
    order.setTotalSavings(ecomAppServiceUtil.roundToTwoDecimalPlaces(order.getTotalSavings()));
    order.setTotalCharges(ecomAppServiceUtil
        .roundToTwoDecimalPlaces(order.getSubTotal() + order.getDeliveryCharges()));
    order.setFormattedDeliveryChanges(ecomAppServiceUtil.formatAmount(order.getDeliveryCharges()));
    order.setFormattedSubTotal(ecomAppServiceUtil.formatAmount(order.getSubTotal()));
    order.setFormattedTotalCharges(ecomAppServiceUtil.formatAmount(order.getTotalCharges()));
    order.setFormattedTotalSavings(ecomAppServiceUtil.formatAmount(order.getTotalSavings()));
    order.setCreateDate(DateTime.now(DateTimeZone.UTC));
    order.setCreatedBy(userEmailId);
    return order;//return order
  }

  /**
   * Service to create order for customer
   *
   * @param productsSelected to be added as part of customer
   * @param userEmailId for which order reated
   * @param deliveryAddressId to where the product needs to be delivered
   * @param selectedPaymentOptions for this delivery
   * @return Order prsisted in DB
   */
  public Order createOrderForCustomer(List<ProductSelected> productsSelected, String userEmailId,
      String deliveryAddressId, PaymentType selectedPaymentOptions) {
    Order order = getOrderForSelectedProducts(productsSelected, userEmailId);
    order.setPaymentType(selectedPaymentOptions);
    order.setOrderStatus(OrderStatus.In_Progress);
    order.setPaymentStatus(PaymentStatus.In_Progress);
    order.setDeliveryStatus(DeliveryStatus.In_Progress);
    CustomerAddress orderDeliveryAddress = null;
    List<CustomerAddress> customerAddresses = findCustomerAddressForEmailId(userEmailId);
    for (CustomerAddress address : customerAddresses) {
      if (address.getCustomerAddressId().equals(deliveryAddressId)) {
        orderDeliveryAddress = address;
        break;
      }
    }
    if (orderDeliveryAddress == null) {
      throw new IllegalArgumentException(String
          .format("Invalid addressId: %s, given by user: %s", deliveryAddressId, userEmailId));
    }
    order.setOrderDeliveryAddress(orderDeliveryAddress);
    orderRepository.save(order);//Order saved
    return order;
  }

  /**
   * Service to save customer address
   *
   * @param customerAddress object
   * @return status
   */
  public String saveCustomerAddress(CustomerAddress customerAddress) {
    customerAddressRepository.save(customerAddress);
    return customerAddress.getCustomerAddressId();
  }

  /**
   * Service to fetch Customer Address For Email Id
   *
   * @param customerAddressForEmailId to be fetched
   * @return List of Customer Address
   */
  public List<CustomerAddress> findCustomerAddressForEmailId(String customerAddressForEmailId) {
    return customerAddressRepository.findAddressForCustomerEmailId(customerAddressForEmailId);
  }

  /**
   * Service to fetch orders for customer
   */
  public Page<Order> fetchOrdersForCustomer(String customerEmailId, int pageNumber, int pageSize) {
    PageRequest pageRequest = new PageRequest(pageNumber, pageSize, new Sort(Sort.Direction.DESC,
        CREATE_DATE));
    return orderRepository.fetchOrdersForCustomer(customerEmailId, pageRequest);
  }

  /**
   * API to fetch order for customer
   *
   * @param orderId to fetch order
   * @param emailId of the user whose orderid is provided
   * @return Order
   */
  public Order fetchOrderForCustomer(String orderId, String emailId) {
    Order order = orderRepository.findOne(orderId);
    if (order == null || !order.getCreatedBy().equals(emailId)) {
      throw new IllegalArgumentException(
          String.format("No matching orderId[ %s ] for customer[ %s ] found!", orderId, emailId));
    }
    return order;
  }

  /**
   * API to save customer query
   */
  public void saveCustomerQuery(CustomerQuery customerQuery) {
    customerQueryRepository.save(customerQuery);
  }
}
