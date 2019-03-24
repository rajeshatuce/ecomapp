package com.rt.model;

import com.rt.constant.EComAppConstant.DeliveryStatus;
import com.rt.constant.EComAppConstant.OrderStatus;
import com.rt.constant.EComAppConstant.PaymentStatus;
import com.rt.constant.EComAppConstant.PaymentType;
import java.util.List;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "order")
public class Order {

  @Id
  private String orderId;
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
  private DateTime createDate;
  private DateTime modifiedDate;
  private String createdBy;
  private String modifiedBy;
  private PaymentType paymentType;
  private OrderStatus orderStatus;
  private PaymentStatus paymentStatus;
  private DeliveryStatus deliveryStatus;
  private CustomerAddress orderDeliveryAddress;
  private DateTime orderDeliveryDate;

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

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public DateTime getCreateDate() {
    return createDate;
  }

  public void setCreateDate(DateTime createDate) {
    this.createDate = createDate;
  }

  public DateTime getModifiedDate() {
    return modifiedDate;
  }

  public void setModifiedDate(DateTime modifiedDate) {
    this.modifiedDate = modifiedDate;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public String getModifiedBy() {
    return modifiedBy;
  }

  public void setModifiedBy(String modifiedBy) {
    this.modifiedBy = modifiedBy;
  }

  public PaymentType getPaymentType() {
    return paymentType;
  }

  public void setPaymentType(PaymentType paymentType) {
    this.paymentType = paymentType;
  }

  public OrderStatus getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(OrderStatus orderStatus) {
    this.orderStatus = orderStatus;
  }

  public PaymentStatus getPaymentStatus() {
    return paymentStatus;
  }

  public void setPaymentStatus(PaymentStatus paymentStatus) {
    this.paymentStatus = paymentStatus;
  }

  public DeliveryStatus getDeliveryStatus() {
    return deliveryStatus;
  }

  public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
    this.deliveryStatus = deliveryStatus;
  }

  public CustomerAddress getOrderDeliveryAddress() {
    return orderDeliveryAddress;
  }

  public void setOrderDeliveryAddress(CustomerAddress orderDeliveryAddress) {
    this.orderDeliveryAddress = orderDeliveryAddress;
  }

  public DateTime getOrderDeliveryDate() {
    return orderDeliveryDate;
  }

  public void setOrderDeliveryDate(DateTime orderDeliveryDate) {
    this.orderDeliveryDate = orderDeliveryDate;
  }
}
