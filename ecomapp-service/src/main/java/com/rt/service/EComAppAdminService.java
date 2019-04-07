package com.rt.service;

import com.rt.model.AppHomeSetting;
import com.rt.model.Product;
import com.rt.model.ProductGroup;
import com.rt.model.UserRoleMapping;
import com.rt.repository.AppHomeSettingRepository;
import com.rt.repository.ProductGroupsRepository;
import com.rt.repository.ProductsRepository;
import com.rt.repository.UserRoleMappingRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
/**
 * Service class to keep all Admin related services
 */
public class EComAppAdminService {

  private final ProductGroupsRepository productGroupsRepository;
  private final ProductsRepository productsRepository;
  private final UserRoleMappingRepository userRoleMappingRepository;
  private final AppHomeSettingRepository appHomeSettingRepository;

  @Autowired
  public EComAppAdminService(ProductGroupsRepository productGroupsRepository,
      ProductsRepository productsRepository, UserRoleMappingRepository userRoleMappingRepository,
      AppHomeSettingRepository appHomeSettingRepository) {
    this.productGroupsRepository = productGroupsRepository;
    this.productsRepository = productsRepository;
    this.userRoleMappingRepository = userRoleMappingRepository;
    this.appHomeSettingRepository = appHomeSettingRepository;
  }

  /**
   * Service to add new product group
   *
   * @param productGroup to be added
   * @return boolean status
   */
  public boolean addProductGroups(ProductGroup productGroup) {
    productGroupsRepository.save(productGroup);
    return true;
  }

  /**
   * Service to get all product group
   */
  public List<ProductGroup> getAllProductGroups() {
    return productGroupsRepository.findAll();
  }

  /**
   * Service to add new product to DB
   * @param product to be added
   * @return boolean addition status
   */
  public boolean addProduct(Product product) {
    productsRepository.save(product);
    return true;
  }

  /**
   * Service to view all product irrespective of status
   * @return List<Product>
   */
  public List<Product> getAllProducts() {
    return productsRepository.findAll();
  }

  /**
   * Admin service to create user role mapping
   *
   * @param userRoleMapping to be added
   */
  public void createUserRoleMapping(UserRoleMapping userRoleMapping) {
    userRoleMappingRepository.save(userRoleMapping);
  }

  /**
   * API to fetch roles for user
   *
   * @param emailId for which we need to find role
   * @return UserRoleMapping
   */
  public List<UserRoleMapping> findRolesForUser(String emailId) {
    return userRoleMappingRepository.findRolesForUser(emailId);
  }

  /**
   * Service to fetch home
   *
   * @return AppHomeSetting
   */
  public AppHomeSetting getHomePageSettings() {
    List<AppHomeSetting> result = appHomeSettingRepository.findAll();
    if (result == null || result.size() == 0) {
      return null;
    } else {
      return result.get(0);//Will have only one entry so return that
    }
  }

  /**
   * Service to fetch HomePageSetting if not available then return default
   *
   * @return AppHomeSetting
   */
  public AppHomeSetting getOrDefaultHomePageSettings() {
    AppHomeSetting appHomeSetting = getHomePageSettings();
    if (appHomeSetting == null) {
      appHomeSetting = new AppHomeSetting();
      appHomeSetting.setAppSubHeaderImageFileName("jeans.jpg");
      appHomeSetting.setAboutHeaderText("About");
      appHomeSetting.setAboutSectionLink1("#");
      appHomeSetting.setAboutSectionLink2("#");
      appHomeSetting.setAboutSectionLink3("#");
      appHomeSetting.setAboutSectionLink4("#");
      appHomeSetting.setAboutSectionLink5("#");
      appHomeSetting.setAboutSectionLink6("#");
      appHomeSetting.setAboutSectionLink7("#");
      appHomeSetting.setAboutSectionLink8("#");
      appHomeSetting.setAboutSectionLink9("#");
      appHomeSetting.setAboutSectionText1("About us");
      appHomeSetting.setAboutSectionText2("We're hiring");
      appHomeSetting.setAboutSectionText3("Support");
      appHomeSetting.setAboutSectionText4("Find store");
      appHomeSetting.setAboutSectionText5("Shipment");
      appHomeSetting.setAboutSectionText6("Payment");
      appHomeSetting.setAboutSectionText7("Gift card");
      appHomeSetting.setAboutSectionText8("Return");
      appHomeSetting.setAboutSectionText9("Help");
      appHomeSetting.setAppLogoText("LOGO");
      appHomeSetting.setAppLogoTextLink("#");
      appHomeSetting.setAppSubHeaderImageButtonText("SHOP NOW");
      appHomeSetting.setAppSubHeaderImageText1("New Arrivals");
      appHomeSetting.setAppSubHeaderImageText2("COLLECTION 2019");
      appHomeSetting.setContactHeaderText("Contact");
      appHomeSetting.setContactSectionText("Questions? Go ahead.");
      appHomeSetting.setStoreHeaderText("Store");
      appHomeSetting.setCompanyLocation("Company Location");
      appHomeSetting.setCompanyPhoneNumber("0044123123");
      appHomeSetting.setCompanyEmailId("ex@mail.com");
      appHomeSetting.setWeAcceptHeaderText("We accept");
      appHomeSetting.setWeAccept1("Amex");
      appHomeSetting.setWeAccept2("Credit Card");
      appHomeSetting.setFaceBookLink("#");
      appHomeSetting.setInstagramLink("#");
      appHomeSetting.setSnapchatLink("#");
      appHomeSetting.setPintrestLink("#");
      appHomeSetting.setTwitterLink("#");
      appHomeSetting.setLinkedInLink("#");
      appHomeSetting.setYoutubeLink("#");
      appHomeSetting.setCurrentYear("2019");
      appHomeSetting.setFooterText(". All rights reserved.");
    }
    return appHomeSetting;
  }

  /**
   * Service to save app home setting
   *
   * @param appHomeSetting to be saved
   */
  public void saveAppHomeSetting(AppHomeSetting appHomeSetting) {
    appHomeSettingRepository.save(appHomeSetting);
  }

}
