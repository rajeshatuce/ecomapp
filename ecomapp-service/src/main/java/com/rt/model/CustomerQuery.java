package com.rt.model;

import com.rt.constant.EComAppConstant.CustomerQueryStatus;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customerQuery")
public class CustomerQuery {

  @Id
  private String customerQueryId;
  private String name;
  private String email;
  private String subject;
  private String message;
  private DateTime createDate;
  private DateTime modifiedDate;
  private CustomerQueryStatus customerQueryStatus;

  public String getCustomerQueryId() {
    return customerQueryId;
  }

  public void setCustomerQueryId(String customerQueryId) {
    this.customerQueryId = customerQueryId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
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

  public CustomerQueryStatus getCustomerQueryStatus() {
    return customerQueryStatus;
  }

  public void setCustomerQueryStatus(
      CustomerQueryStatus customerQueryStatus) {
    this.customerQueryStatus = customerQueryStatus;
  }
}
