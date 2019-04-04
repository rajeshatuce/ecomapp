package com.rt.controller;

import static com.rt.constant.EComAppConstant.ECOMAPP_ADMIN_HOMEPAGE;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rt.service.EComAppAdminService;
import com.rt.util.EComAppCDNUrlBuilder;
import com.rt.util.EcomAppServiceUtil;
import java.security.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ECom app Admin main controller
 */
@Controller
@Secured("ROLE_ADMIN")
public class EComAppAdminWebController {

  private static final Logger LOGGER = LoggerFactory.getLogger(EComAppAdminWebController.class);
  private final EcomAppServiceUtil ecomAppServiceUtil;
  private EComAppCDNUrlBuilder eComAppCDNUrlBuilder;
  private EComAppAdminService eComAppAdminService;
  private ObjectMapper objectMapper = new ObjectMapper();

  @Autowired
  public EComAppAdminWebController(EComAppCDNUrlBuilder eComAppCDNUrlBuilder,
      EComAppAdminService eComAppAdminService,
      EcomAppServiceUtil ecomAppServiceUtil) {
    this.eComAppCDNUrlBuilder = eComAppCDNUrlBuilder;
    this.eComAppAdminService = eComAppAdminService;
    this.ecomAppServiceUtil = ecomAppServiceUtil;
  }

  @RequestMapping("/admin/home")
  public String renderEComAppAdminHomePage(Model model, Principal principal) {
    String emailId = ecomAppServiceUtil.getEmailIdFromPrincipalObject(principal);
    LOGGER.info("Rendering Admin homepage for:{}", emailId);
    eComAppCDNUrlBuilder.addCDNUrlToModel(model);
    return ECOMAPP_ADMIN_HOMEPAGE;
  }
}
