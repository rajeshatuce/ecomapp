package com.rt.service;

import com.rt.model.Product;
import com.rt.model.ProductGroup;
import com.rt.repository.ProductGroupsRepository;
import com.rt.repository.ProductsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EComAppAdminService {

  private final ProductGroupsRepository productGroupsRepository;
  private final ProductsRepository productsRepository;

  @Autowired
  public EComAppAdminService(ProductGroupsRepository productGroupsRepository,
      ProductsRepository productsRepository) {
    this.productGroupsRepository = productGroupsRepository;
    this.productsRepository = productsRepository;
  }

  public boolean addProductGroups(ProductGroup productGroup) {
    productGroupsRepository.save(productGroup);
    return true;
  }

  public List<ProductGroup> getAllProductGroups() {
    return productGroupsRepository.findAll();
  }

  public boolean addProduct(Product product) {
    productsRepository.save(product);
    return true;
  }

  public List<Product> getAllProducts() {
    return productsRepository.findAll();
  }

}
