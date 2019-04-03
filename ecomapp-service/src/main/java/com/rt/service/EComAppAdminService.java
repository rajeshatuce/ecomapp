package com.rt.service;

import com.rt.model.Product;
import com.rt.model.ProductGroup;
import com.rt.model.UserRoleMapping;
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

  @Autowired
  public EComAppAdminService(ProductGroupsRepository productGroupsRepository,
      ProductsRepository productsRepository, UserRoleMappingRepository userRoleMappingRepository) {
    this.productGroupsRepository = productGroupsRepository;
    this.productsRepository = productsRepository;
    this.userRoleMappingRepository = userRoleMappingRepository;
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

}
