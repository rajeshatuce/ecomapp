package com.rt.model;

public class ProductCheckout {

  private String productId;
  private Integer selectedQuantity;
  private String name;
  private String uniqueFileName;
  private double currentUnitPrice;
  private double previousUnitPrice;
  private double subTotal;
  private double savingsAmount;
  private String formattedSubTotal;
  private String formattedSavingsAmount;
  private String currencyLabel;

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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUniqueFileName() {
    return uniqueFileName;
  }

  public void setUniqueFileName(String uniqueFileName) {
    this.uniqueFileName = uniqueFileName;
  }

  public double getCurrentUnitPrice() {
    return currentUnitPrice;
  }

  public void setCurrentUnitPrice(double currentUnitPrice) {
    this.currentUnitPrice = currentUnitPrice;
  }

  public double getPreviousUnitPrice() {
    return previousUnitPrice;
  }

  public void setPreviousUnitPrice(double previousUnitPrice) {
    this.previousUnitPrice = previousUnitPrice;
  }

  public double getSubTotal() {
    return subTotal;
  }

  public void setSubTotal(double subTotal) {
    this.subTotal = subTotal;
  }

  public double getSavingsAmount() {
    return savingsAmount;
  }

  public void setSavingsAmount(double savingsAmount) {
    this.savingsAmount = savingsAmount;
  }

  public String getFormattedSubTotal() {
    return formattedSubTotal;
  }

  public void setFormattedSubTotal(String formattedSubTotal) {
    this.formattedSubTotal = formattedSubTotal;
  }

  public String getFormattedSavingsAmount() {
    return formattedSavingsAmount;
  }

  public void setFormattedSavingsAmount(String formattedSavingsAmount) {
    this.formattedSavingsAmount = formattedSavingsAmount;
  }

  public String getCurrencyLabel() {
    return currencyLabel;
  }

  public void setCurrencyLabel(String currencyLabel) {
    this.currencyLabel = currencyLabel;
  }
}
