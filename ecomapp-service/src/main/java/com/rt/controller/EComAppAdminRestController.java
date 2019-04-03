package com.rt.controller;

import static com.rt.constant.EComAppConstant.STATUS;
import static com.rt.constant.EComAppConstant.TRUE;

import com.rt.model.Product;
import com.rt.model.ProductGroup;
import com.rt.model.UserRoleMapping;
import com.rt.service.EComAppAdminService;
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
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Secured("ROLE_ADMIN")
/**
 * REST controller to store admin related API
 */
public class EComAppAdminRestController {

  private static final Logger LOGGER = LoggerFactory.getLogger(EComAppAdminRestController.class);
  private final EComAppAdminService eComAppAdminService;
  private final EcomAppServiceUtil ecomAppServiceUtil;

  @Autowired
  public EComAppAdminRestController(EComAppAdminService eComAppAdminService,
      EcomAppServiceUtil ecomAppServiceUtil) {
    this.eComAppAdminService = eComAppAdminService;
    this.ecomAppServiceUtil = ecomAppServiceUtil;
  }

  /**
   * API to add new user role mapping
   *
   * @param userRoleMapping to be added to DB
   * @param principal object
   * @return status
   */
  @RequestMapping(value = "/admin/addUserRoleMapping", method = RequestMethod.POST)
  public Map<String, String> addUserRoleMapping(@RequestBody UserRoleMapping userRoleMapping,
      Principal principal) {
    Map<String, String> result = new HashMap<>();
    String emailId = ecomAppServiceUtil.getEmailIdFromPrincipalObject(principal);
    LOGGER.info("Adding New User Role Mapping by :{}", emailId);
    userRoleMapping.setCreatedBy(emailId);
    userRoleMapping.setCreateDate(DateTime.now(DateTimeZone.UTC));
    eComAppAdminService.createUserRoleMapping(userRoleMapping);
    result.put(STATUS, TRUE);
    return result;
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
   * API to fetch all productGroups from DB
   *
   * @return List<ProductGroup>
   */
  @RequestMapping(value = "/admin/getAllProductGroups", method = RequestMethod.GET)
  public List<ProductGroup> getAllProductGroups() {
    LOGGER.info("Fetching all product groups");
    return eComAppAdminService.getAllProductGroups();
  }

  /**
   * API to get all products
   *
   * @return List<Product>
   */
  @RequestMapping(value = "/admin/getAllProducts", method = RequestMethod.GET)
  public List<Product> getAllProducts() {
    LOGGER.info("Fetch all products");
    return eComAppAdminService.getAllProducts();
  }
}
