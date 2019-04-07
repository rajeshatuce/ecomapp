package com.rt.controller;

import static com.rt.constant.EComAppConstant.ACTIVE_PRODUCTS;
import static com.rt.constant.EComAppConstant.APP_HOME_SETTING;
import static com.rt.constant.EComAppConstant.ECOMAPP_CHECKOUT_PAGE;
import static com.rt.constant.EComAppConstant.ECOMAPP_HOMEPAGE;
import static com.rt.constant.EComAppConstant.ECOMAPP_MY_ORDERS_PAGE;
import static com.rt.constant.EComAppConstant.ORDER;
import static com.rt.constant.EComAppConstant.ORDER_PAGE;
import static com.rt.constant.EComAppConstant.SHOPPING_CART_VALUE;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rt.constant.EComAppConstant.PaymentType;
import com.rt.model.ProductSelected;
import com.rt.service.EComAppAdminService;
import com.rt.service.EComAppService;
import com.rt.util.EComAppCDNUrlBuilder;
import com.rt.util.EcomAppServiceUtil;
import java.security.Principal;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * ECom app main controller
 */
@Controller
public class EComAppWebController {

  private static final Logger LOGGER = LoggerFactory.getLogger(EComAppWebController.class);
  private EComAppCDNUrlBuilder eComAppCDNUrlBuilder;
  private EComAppService eComAppService;
  private ObjectMapper objectMapper = new ObjectMapper();
  private final EcomAppServiceUtil ecomAppServiceUtil;
  private final EComAppAdminService eComAppAdminService;

  /**
   * Constructor for the Web Controller
   *
   * @param eComAppCDNUrlBuilder to create
   * @param eComAppService to create
   * @param ecomAppServiceUtil to create
   */
  @Autowired
  public EComAppWebController(EComAppCDNUrlBuilder eComAppCDNUrlBuilder,
      EComAppService eComAppService,
      EcomAppServiceUtil ecomAppServiceUtil, EComAppAdminService eComAppAdminService) {
    this.eComAppCDNUrlBuilder = eComAppCDNUrlBuilder;
    this.eComAppService = eComAppService;
    this.ecomAppServiceUtil = ecomAppServiceUtil;
    this.eComAppAdminService = eComAppAdminService;
  }

  /**
   * Function to be called when opening home page for the app
   * @param model which we need to set so the FTL can pickup data from there
   * @return FTL page name which need to be rendered
   */
  @RequestMapping("/")
  public String getEComAppIndexPage(Model model) {
    LOGGER.info("Rendering homepage");
    eComAppCDNUrlBuilder.addCDNUrlToModel(model);
    model.addAttribute(APP_HOME_SETTING, eComAppAdminService.getOrDefaultHomePageSettings());
    model.addAttribute(ACTIVE_PRODUCTS, eComAppService.getActiveProducts());
    return ECOMAPP_HOMEPAGE;
  }

  @RequestMapping(value = "/checkout", method = RequestMethod.GET)
  public String getEComAppCheckoutPage(@RequestParam("shoppingCartValue") String shoppingCartValue,
      Principal user, Model model) throws Exception {
    String emailId = ecomAppServiceUtil.getEmailIdFromPrincipalObject(user);
    LOGGER.info("Rendering checkout page for customer:{}", emailId);
    eComAppCDNUrlBuilder.addCDNUrlToModel(model);
    model.addAttribute(APP_HOME_SETTING, eComAppAdminService.getOrDefaultHomePageSettings());
    List<ProductSelected> productsSelected = objectMapper
        .readValue(shoppingCartValue, new TypeReference<List<ProductSelected>>() {
        });
    model
        .addAttribute(ORDER, eComAppService.getOrderForSelectedProducts(productsSelected, emailId));
    model.addAttribute(SHOPPING_CART_VALUE, shoppingCartValue);
    model.addAttribute(ORDER_PAGE, false);
    return ECOMAPP_CHECKOUT_PAGE;
  }

  @RequestMapping(value = "/createOrderForCustomer", method = RequestMethod.POST)
  public String createOrderForCustomer(
      @RequestParam("productsToPlaceOrder") String productsToPlaceOrder,
      @RequestParam("deliveryAddressId") String deliveryAddressId,
      @RequestParam("selectedPaymentOptions") PaymentType selectedPaymentOptions,
      Principal user, Model model) throws Exception {
    String emailId = ecomAppServiceUtil.getEmailIdFromPrincipalObject(user);
    LOGGER.info("creating order for customer:{}", emailId);
    eComAppCDNUrlBuilder.addCDNUrlToModel(model);
    model.addAttribute(APP_HOME_SETTING, eComAppAdminService.getOrDefaultHomePageSettings());
    List<ProductSelected> productsSelected = objectMapper
        .readValue(productsToPlaceOrder, new TypeReference<List<ProductSelected>>() {
        });
    model.addAttribute(ORDER, eComAppService
        .createOrderForCustomer(productsSelected, emailId, deliveryAddressId,
            selectedPaymentOptions));
    model.addAttribute(SHOPPING_CART_VALUE, productsToPlaceOrder);
    model.addAttribute(ORDER_PAGE, true);
    return ECOMAPP_CHECKOUT_PAGE;
  }

  @RequestMapping("/myOrders")
  public String getEComAppMyOrdersPage(Model model) {
    LOGGER.info("Rendering my orders page");
    eComAppCDNUrlBuilder.addCDNUrlToModel(model);
    model.addAttribute(APP_HOME_SETTING, eComAppAdminService.getOrDefaultHomePageSettings());
    return ECOMAPP_MY_ORDERS_PAGE;
  }

  @RequestMapping(value = "/viewOrdersForCustomer", method = RequestMethod.GET)
  public String viewOrdersForCustomer(@RequestParam("orderId") String orderId, Model model,
      Principal user) {
    eComAppCDNUrlBuilder.addCDNUrlToModel(model);
    String emailId = ecomAppServiceUtil.getEmailIdFromPrincipalObject(user);
    LOGGER.info("Rendering details for order ID : {}, for customer: {}", orderId, emailId);
    model.addAttribute(APP_HOME_SETTING, eComAppAdminService.getOrDefaultHomePageSettings());
    model.addAttribute(ORDER, eComAppService
        .fetchOrderForCustomer(orderId, emailId));
    model.addAttribute(ORDER_PAGE, true);
    return ECOMAPP_CHECKOUT_PAGE;
  }
}
