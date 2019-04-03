package com.rt.model;

import com.rt.constant.EComAppConstant.UserRole;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userRoleMapping")
public class UserRoleMapping {

  @Id
  private String userRoleMappingId;
  private String emailId;
  private UserRole userRole;
  private DateTime createDate;
  private String createdBy;

  public String getUserRoleMappingId() {
    return userRoleMappingId;
  }

  public void setUserRoleMappingId(String userRoleMappingId) {
    this.userRoleMappingId = userRoleMappingId;
  }

  public String getEmailId() {
    return emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  public UserRole getUserRole() {
    return userRole;
  }

  public void setUserRole(UserRole userRole) {
    this.userRole = userRole;
  }

  public DateTime getCreateDate() {
    return createDate;
  }

  public void setCreateDate(DateTime createDate) {
    this.createDate = createDate;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }
}
