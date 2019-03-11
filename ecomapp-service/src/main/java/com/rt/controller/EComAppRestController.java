package com.rt.controller;

import com.rt.model.Product;
import com.rt.model.ProductGroup;
import com.rt.service.EComAppAdminService;
import com.rt.util.EcomAppServiceUtil;
import java.security.Principal;
import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EComAppRestController {

  private static final Logger LOGGER = LoggerFactory.getLogger(EComAppRestController.class);

  private EComAppAdminService eComAppAdminService;
  private EcomAppServiceUtil ecomAppServiceUtil;

  @Autowired
  public EComAppRestController(EComAppAdminService eComAppAdminService,
      EcomAppServiceUtil ecomAppServiceUtil) {
    this.eComAppAdminService = eComAppAdminService;
    this.ecomAppServiceUtil = ecomAppServiceUtil;
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

  @RequestMapping(value = "/getAllProducts", method = RequestMethod.GET)
  public List<Product> getAllProducts() {
    LOGGER.info("Fetch all products");
    return eComAppAdminService.getAllProducts();
  }



}
