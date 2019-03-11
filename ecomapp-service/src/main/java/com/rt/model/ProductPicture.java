package com.rt.model;

public class ProductPicture {

  private String uniqueFileName;
  private boolean productThumbNail;

  public String getUniqueFileName() {
    return uniqueFileName;
  }

  public void setUniqueFileName(String uniqueFileName) {
    this.uniqueFileName = uniqueFileName;
  }

  public boolean isProductThumbNail() {
    return productThumbNail;
  }

  public void setProductThumbNail(boolean productThumbNail) {
    this.productThumbNail = productThumbNail;
  }
}
