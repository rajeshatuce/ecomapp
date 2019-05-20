package com.rt.controller;

import static com.rt.constant.EComAppConstant.STATUS;
import static com.rt.constant.EComAppConstant.TRUE;

import com.rt.model.AppHomeSetting;
import com.rt.model.Product;
import com.rt.model.ProductGroup;
import com.rt.model.UserRoleMapping;
import com.rt.service.EComAppAdminService;
import com.rt.service.EComAppFileManagerService;
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
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
  private final EComAppFileManagerService eComAppFileManagerService;

  @Autowired
  public EComAppAdminRestController(EComAppAdminService eComAppAdminService,
      EcomAppServiceUtil ecomAppServiceUtil, EComAppFileManagerService eComAppFileManagerService) {
    this.eComAppAdminService = eComAppAdminService;
    this.ecomAppServiceUtil = ecomAppServiceUtil;
    this.eComAppFileManagerService = eComAppFileManagerService;
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
   * REST service to save product group to DB
   *
   * @param productGroup document
   * @param user who is adding the productGroup
   * @return boolean status
   */
  @RequestMapping(value = "/admin/saveProductGroup", method = RequestMethod.POST)
  public boolean saveProductGroup(@RequestBody ProductGroup productGroup, Principal user) {
    LOGGER.info("Saving product group");
    if (productGroup.getId() == null) {
      productGroup.setCreatedBy(ecomAppServiceUtil.getEmailIdFromPrincipalObject(user));
      productGroup.setCreateDate(DateTime.now(DateTimeZone.UTC));
    } else {
      ProductGroup oldProductGroup = eComAppAdminService.getProductGroup(productGroup.getId());
      productGroup.setCreateDate(oldProductGroup.getCreateDate());
      productGroup.setCreatedBy(oldProductGroup.getCreatedBy());
      productGroup.setModifiedBy(ecomAppServiceUtil.getEmailIdFromPrincipalObject(user));
      productGroup.setModifiedDate(DateTime.now(DateTimeZone.UTC));
    }
    eComAppAdminService.saveProductGroups(productGroup);
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
  public Page<Product> getAllProducts(
      @RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
      @RequestParam(value = "pageSize", defaultValue = "50") Integer pageSize) {
    LOGGER.info("Fetch all products for pageNumber: {}, pageSize: {}", pageNumber, pageSize);
    return eComAppAdminService.getAllProducts(pageNumber, pageSize);
  }

  /**
   * REST API to save home page settings
   *
   * @param appHomeSetting to be persisted
   * @param principal user who is saving the data
   */
  @RequestMapping(value = "/admin/saveHomePageSettings", method = RequestMethod.POST)
  public void saveHomePageSettings(@ModelAttribute AppHomeSetting appHomeSetting,
      Principal principal) throws Exception {
    String emailId = ecomAppServiceUtil.getEmailIdFromPrincipalObject(principal);
    LOGGER.info("Home page setting is getting saved by user: {}", emailId);
    //1. Save image if any uploaded onto image CDN
    if (appHomeSetting.getAppSubHeaderNewImageFile() != null) {//New image uploaded by user
      appHomeSetting.setAppSubHeaderImageFileName(eComAppFileManagerService.saveImagesToCDNLocation(
          appHomeSetting
              .getAppSubHeaderNewImageFile()));//Save new file at CDN and update name at app metadata
    }
    //2. Add/Update HomePageSetting data
    appHomeSetting.setModifiedDate(DateTime.now(DateTimeZone.UTC));
    appHomeSetting.setModifiedBy(emailId);
    if (appHomeSetting.getId() != null && appHomeSetting.getId().length() == 0) {
      appHomeSetting.setId(null);
    }
    eComAppAdminService.saveAppHomeSetting(appHomeSetting);
  }

  /**
   * REST API to fetch home page settings
   *
   * @param principal who is requesting details
   * @return AppHomeSetting
   */
  @RequestMapping(value = "/admin/getHomePageSettings", method = RequestMethod.GET)
  public AppHomeSetting getHomePageSettings(Principal principal) {
    String emailId = ecomAppServiceUtil.getEmailIdFromPrincipalObject(principal);
    LOGGER.info("Home page setting is fetched by user: {}", emailId);
    return eComAppAdminService.getOrDefaultHomePageSettings();
  }
}
