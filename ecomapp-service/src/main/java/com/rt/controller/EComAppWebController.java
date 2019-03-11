package com.rt.controller;

import static com.rt.constant.EComAppConstant.ACTIVE_PRODUCTS;
import static com.rt.constant.EComAppConstant.ECOMAPP_CHECKOUT_PAGE;
import static com.rt.constant.EComAppConstant.ECOMAPP_HOMEPAGE;
import static com.rt.constant.EComAppConstant.ECOMAPP_MY_ORDERS_PAGE;

import com.rt.service.EComAppService;
import com.rt.util.EComAppCDNUrlBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * ECom app main controller
 */
@Controller
public class EComAppWebController {

  private static final Logger LOGGER = LoggerFactory.getLogger(EComAppWebController.class);
  private EComAppCDNUrlBuilder eComAppCDNUrlBuilder;
  private EComAppService eComAppService;

  @Autowired
  public EComAppWebController(EComAppCDNUrlBuilder eComAppCDNUrlBuilder,
      EComAppService eComAppService) {
    this.eComAppCDNUrlBuilder = eComAppCDNUrlBuilder;
    this.eComAppService = eComAppService;
  }

  @RequestMapping("/")
  public String getEComAppIndexPage(Model model) {
    LOGGER.info("Rendering homepage");
    eComAppCDNUrlBuilder.addCDNUrlToModel(model);
    model.addAttribute(ACTIVE_PRODUCTS, eComAppService.getActiveProducts());
    return ECOMAPP_HOMEPAGE;
  }

  @RequestMapping("/checkout")
  public String getEComAppCheckoutPage(Model model) {
    eComAppCDNUrlBuilder.addCDNUrlToModel(model);
    LOGGER.info("Rendering checkout page");
    return ECOMAPP_CHECKOUT_PAGE;
  }

  @RequestMapping("/myOrders")
  public String getEComAppMyOrdersPage(Model model) {
    eComAppCDNUrlBuilder.addCDNUrlToModel(model);
    LOGGER.info("Rendering my orders page");
    return ECOMAPP_MY_ORDERS_PAGE;
  }
}
