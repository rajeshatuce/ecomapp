package com.rt.model;

import com.rt.constant.EComAppConstant.CustomerAddressType;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customerAddress")
public class CustomerAddress {

  @Id
  private String customerAddressId;
  private String customerName;
  private CustomerAddressType customerAddressType;
  private String deliveryFullName;
  private String mobileNumber;
  private String pincode;
  private String address1;
  private String address2;
  private String landmark;
  private String townCity;
  private String state;
  private DateTime createDate;
  private DateTime modifiedDate;
  private String createdBy;
  private String modifiedBy;
  private String customerAddressForEmailId;
  private boolean selectedForDelivery;

  public CustomerAddressType getCustomerAddressType() {
    return customerAddressType;
  }

  public void setCustomerAddressType(
      CustomerAddressType customerAddressType) {
    this.customerAddressType = customerAddressType;
  }

  public String getDeliveryFullName() {
    return deliveryFullName;
  }

  public void setDeliveryFullName(String deliveryFullName) {
    this.deliveryFullName = deliveryFullName;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public String getPincode() {
    return pincode;
  }

  public void setPincode(String pincode) {
    this.pincode = pincode;
  }

  public String getAddress1() {
    return address1;
  }

  public void setAddress1(String address1) {
    this.address1 = address1;
  }

  public String getAddress2() {
    return address2;
  }

  public void setAddress2(String address2) {
    this.address2 = address2;
  }

  public String getLandmark() {
    return landmark;
  }

  public void setLandmark(String landmark) {
    this.landmark = landmark;
  }

  public String getTownCity() {
    return townCity;
  }

  public void setTownCity(String townCity) {
    this.townCity = townCity;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCustomerAddressId() {
    return customerAddressId;
  }

  public void setCustomerAddressId(String customerAddressId) {
    this.customerAddressId = customerAddressId;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
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

  public String getCustomerAddressForEmailId() {
    return customerAddressForEmailId;
  }

  public void setCustomerAddressForEmailId(String customerAddressForEmailId) {
    this.customerAddressForEmailId = customerAddressForEmailId;
  }

  public boolean isSelectedForDelivery() {
    return selectedForDelivery;
  }

  public void setSelectedForDelivery(boolean selectedForDelivery) {
    this.selectedForDelivery = selectedForDelivery;
  }
}
