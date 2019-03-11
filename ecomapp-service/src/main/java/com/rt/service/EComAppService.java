package com.rt.service;

import com.rt.constant.EComAppConstant.Status;
import com.rt.model.Product;
import com.rt.repository.ProductsRepository;
import com.rt.util.EcomAppServiceUtil;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EComAppService {

  private final ProductsRepository productsRepository;
  private final EcomAppServiceUtil ecomAppServiceUtil;

  @Autowired
  public EComAppService(ProductsRepository productsRepository,
      EcomAppServiceUtil ecomAppServiceUtil) {
    this.productsRepository = productsRepository;
    this.ecomAppServiceUtil = ecomAppServiceUtil;
  }

  public Map<String, List<Product>> getActiveProducts() {
    List<Product> products = productsRepository.findProductsByStatus(Status.Active.toString());
    return ecomAppServiceUtil.groupSimilarProductTogether(products);
  }
}
