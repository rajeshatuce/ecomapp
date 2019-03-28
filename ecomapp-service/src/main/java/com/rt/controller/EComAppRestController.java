package com.rt.controller;

import static com.rt.constant.EComAppConstant.CUSTOMER_ADDRESS_ID;

import com.rt.model.CustomerAddress;
import com.rt.model.Order;
import com.rt.model.Product;
import com.rt.model.ProductGroup;
import com.rt.service.EComAppAdminService;
import com.rt.service.EComAppService;
import com.rt.util.EcomAppServiceUtil;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EComAppRestController {

  private static final Logger LOGGER = LoggerFactory.getLogger(EComAppRestController.class);

  private final EComAppAdminService eComAppAdminService;
  private final EcomAppServiceUtil ecomAppServiceUtil;
  private final EComAppService eComAppService;

  @Autowired
  public EComAppRestController(EComAppAdminService eComAppAdminService,
      EcomAppServiceUtil ecomAppServiceUtil, EComAppService eComAppService) {
    this.eComAppAdminService = eComAppAdminService;
    this.ecomAppServiceUtil = ecomAppServiceUtil;
    this.eComAppService = eComAppService;
  }

  /**
   * REST endpoint to get logged in user details
   *
   * @param user logged in
   * @return Principal Object
   */
  @RequestMapping("/user")
  public Principal user(Principal user) {
    return user;
  }

  /**
   * REST service to add product group to DB
   *
   * @param productGroup document
   * @param user who is adding the productGroup
   * @return boolean status
   */
  @RequestMapping(value = "/admin/addProductGroup", method = RequestMethod.POST)
  public boolean addProductGroup(@RequestBody ProductGroup productGroup, Principal user) {
    LOGGER.info("Adding product group");
    productGroup.setCreatedBy(ecomAppServiceUtil.getEmailIdFromPrincipalObject(user));
    productGroup.setCreateDate(DateTime.now(DateTimeZone.UTC));
    eComAppAdminService.addProductGroups(productGroup);
    return true;
  }

  /**
   * API to fetch all productGroups from DB
   *
   * @return List<ProductGroup>
   */
  @RequestMapping(value = "/getAllProductGroups", method = RequestMethod.GET)
  public List<ProductGroup> getAllProductGroups() {
    LOGGER.info("Fetching all product groups");
    return eComAppAdminService.getAllProductGroups();
  }

  /**
   * API to addProduct
   *
   * @param product information
   * @param user who is adding product
   * @return boolean result
   */
  @RequestMapping(value = "/admin/addProduct", method = RequestMethod.POST)
  public boolean addProduct(@RequestBody Product product, Principal user) {
    LOGGER.info("Adding product to DB");
    product.setCreatedBy(ecomAppServiceUtil.getEmailIdFromPrincipalObject(user));
    product.setCreateDate(DateTime.now(DateTimeZone.UTC));
    eComAppAdminService.addProduct(product);
    return true;
  }

  /**
   * API to add new customer address
   *
   * @param customerAddress to be added to db
   * @param principal user who is adding address
   * @return status
   */
  @RequestMapping(value = "/addNewCustomerAddress", method = RequestMethod.POST)
  public Map<String, String> addNewCustomerAddress(@RequestBody CustomerAddress customerAddress,
      Principal principal) {
    Map<String, String> result = new HashMap<>();
    String emailId = ecomAppServiceUtil.getEmailIdFromPrincipalObject(principal);
    LOGGER.info("Adding New Customer Address by :{}", emailId);
    customerAddress.setCreatedBy(emailId);
    customerAddress.setCreateDate(DateTime.now(DateTimeZone.UTC));
    customerAddress.setCustomerName(principal.getName());
    customerAddress.setCustomerAddressForEmailId(emailId);
    result.put(CUSTOMER_ADDRESS_ID, eComAppService.saveCustomerAddress(customerAddress));
    return result;
  }

  @RequestMapping(value = "/getAllProducts", method = RequestMethod.GET)
  public List<Product> getAllProducts() {
    LOGGER.info("Fetch all products");
    return eComAppAdminService.getAllProducts();
  }

  @RequestMapping(value = "/fetchCustomerAddress", method = RequestMethod.GET)
  public List<CustomerAddress> fetchCustomerAddress(Principal principal) {
    String emailId = ecomAppServiceUtil.getEmailIdFromPrincipalObject(principal);
    LOGGER.info("Fetching customer address for :{}", emailId);
    return eComAppService.findCustomerAddressForEmailId(emailId);
  }

  /**
   * API to fetch orders for logged in user
   *
   * @param principal for which orders need to be shown
   * @return Orders
   */
  @RequestMapping(value = "/fetchCustomerOrders", method = RequestMethod.GET)
  public Page<Order> fetchCustomerOrders(
      @RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
      @RequestParam(value = "pageSize", defaultValue = "50") Integer pageSize,
      Principal principal) {
    String emailId = ecomAppServiceUtil.getEmailIdFromPrincipalObject(principal);
    LOGGER.info("Fetching orders for customer :{}, pageNumber:{}, pageSize:{}", emailId, pageNumber,
        pageSize);
    return eComAppService.fetchOrdersForCustomer(emailId, pageNumber, pageSize);
  }



}
