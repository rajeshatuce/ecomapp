package com.rt.controller;

import static com.rt.constant.EComAppConstant.CUSTOMER_ADDRESS_ID;
import static com.rt.constant.EComAppConstant.STATUS;
import static com.rt.constant.EComAppConstant.TRUE;

import com.rt.constant.EComAppConstant.CustomerQueryStatus;
import com.rt.model.CustomerAddress;
import com.rt.model.CustomerQuery;
import com.rt.model.Order;
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

  private final EcomAppServiceUtil ecomAppServiceUtil;
  private final EComAppService eComAppService;

  @Autowired
  public EComAppRestController(EcomAppServiceUtil ecomAppServiceUtil,
      EComAppService eComAppService) {
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

  /**
   * API to post customer query
   *
   * @return response
   */
  @RequestMapping(value = "/general/postCustomerQuery", method = RequestMethod.POST)
  public Map<String, String> postCustomerQuery(@RequestBody CustomerQuery customerQuery,
      Principal principal) {
    if (principal != null) {
      String emailId = ecomAppServiceUtil.getEmailIdFromPrincipalObject(principal);
      LOGGER.info("Saving customer query for emailId: {}", emailId);
      customerQuery.setEmail(emailId);
      customerQuery.setName(principal.getName());
    } else {
      LOGGER.info("Saving customer query");
    }
    customerQuery.setCreateDate(DateTime.now(DateTimeZone.UTC));
    customerQuery.setCustomerQueryStatus(CustomerQueryStatus.Pending);
    eComAppService.saveCustomerQuery(customerQuery);
    Map<String, String> result = new HashMap<>();
    result.put(STATUS, TRUE);
    return result;
  }



}
