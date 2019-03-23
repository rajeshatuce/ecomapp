package com.rt.service;

import com.rt.constant.EComAppConstant.Status;
import com.rt.model.CustomerAddress;
import com.rt.model.Order;
import com.rt.model.Product;
import com.rt.model.ProductCheckout;
import com.rt.model.ProductPicture;
import com.rt.model.ProductSelected;
import com.rt.repository.CustomerAddressRepository;
import com.rt.repository.ProductsRepository;
import com.rt.util.EcomAppServiceUtil;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EComAppService {

  private final ProductsRepository productsRepository;
  private final EcomAppServiceUtil ecomAppServiceUtil;
  private final CustomerAddressRepository customerAddressRepository;

  @Autowired
  public EComAppService(ProductsRepository productsRepository,
      EcomAppServiceUtil ecomAppServiceUtil, CustomerAddressRepository customerAddressRepository) {
    this.productsRepository = productsRepository;
    this.ecomAppServiceUtil = ecomAppServiceUtil;
    this.customerAddressRepository = customerAddressRepository;
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
   * @param user who is selecting product
   * @return Order object
   */
  public Order getOrderForSelectedProducts(List<ProductSelected> productsSelected, Principal user) {
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
    return order;//return order
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

  public List<CustomerAddress> findCustomerAddressForEmailId(String customerAddressForEmailId) {
    return customerAddressRepository.findAddressForCustomerEmailId(customerAddressForEmailId);
  }


}
