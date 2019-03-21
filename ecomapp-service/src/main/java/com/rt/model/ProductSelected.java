package com.rt.model;

public class ProductSelected {

  private String productId;
  private Integer selectedQuantity;

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public Integer getSelectedQuantity() {
    return selectedQuantity;
  }

  public void setSelectedQuantity(Integer selectedQuantity) {
    this.selectedQuantity = selectedQuantity;
  }
}
