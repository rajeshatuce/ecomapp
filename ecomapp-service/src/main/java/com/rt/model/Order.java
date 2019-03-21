package com.rt.model;

import java.util.List;

public class Order {

  private List<ProductCheckout> productsOrdered;
  private double subTotal;
  private double deliveryCharges;
  private double totalCharges;
  private double totalSavings;
  private String currencyLabel;
  private String formattedSubTotal;
  private String formattedDeliveryChanges;
  private String formattedTotalSavings;
  private String formattedTotalCharges;

  public List<ProductCheckout> getProductsOrdered() {
    return productsOrdered;
  }

  public void setProductsOrdered(List<ProductCheckout> productsOrdered) {
    this.productsOrdered = productsOrdered;
  }

  public double getSubTotal() {
    return subTotal;
  }

  public void setSubTotal(double subTotal) {
    this.subTotal = subTotal;
  }

  public double getDeliveryCharges() {
    return deliveryCharges;
  }

  public void setDeliveryCharges(double deliveryCharges) {
    this.deliveryCharges = deliveryCharges;
  }

  public double getTotalCharges() {
    return totalCharges;
  }

  public void setTotalCharges(double totalCharges) {
    this.totalCharges = totalCharges;
  }

  public double getTotalSavings() {
    return totalSavings;
  }

  public void setTotalSavings(double totalSavings) {
    this.totalSavings = totalSavings;
  }

  public String getCurrencyLabel() {
    return currencyLabel;
  }

  public void setCurrencyLabel(String currencyLabel) {
    this.currencyLabel = currencyLabel;
  }

  public String getFormattedSubTotal() {
    return formattedSubTotal;
  }

  public void setFormattedSubTotal(String formattedSubTotal) {
    this.formattedSubTotal = formattedSubTotal;
  }

  public String getFormattedDeliveryChanges() {
    return formattedDeliveryChanges;
  }

  public void setFormattedDeliveryChanges(String formattedDeliveryChanges) {
    this.formattedDeliveryChanges = formattedDeliveryChanges;
  }

  public String getFormattedTotalSavings() {
    return formattedTotalSavings;
  }

  public void setFormattedTotalSavings(String formattedTotalSavings) {
    this.formattedTotalSavings = formattedTotalSavings;
  }

  public String getFormattedTotalCharges() {
    return formattedTotalCharges;
  }

  public void setFormattedTotalCharges(String formattedTotalCharges) {
    this.formattedTotalCharges = formattedTotalCharges;
  }
}
