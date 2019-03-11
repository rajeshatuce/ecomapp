package com.rt.model;

import com.rt.constant.EComAppConstant.Status;
import java.util.List;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {

  @Id
  private String id;
  private String name;
  private String productGroup;
  private String shortDescription;
  private String pointsDescription;
  private int starRating;
  private double currentUnitPrice;
  private double previousUnitPrice;
  private int maxQuantityPerOrder;
  private Status status;
  private String textOnImage;
  private DateTime createDate;
  private DateTime modifiedDate;
  private String createdBy;
  private String modifiedBy;
  private List<ProductPicture> productPictures;
  private String currencyLabel;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getProductGroup() {
    return productGroup;
  }

  public void setProductGroup(String productGroup) {
    this.productGroup = productGroup;
  }

  public String getShortDescription() {
    return shortDescription;
  }

  public void setShortDescription(String shortDescription) {
    this.shortDescription = shortDescription;
  }

  public String getPointsDescription() {
    return pointsDescription;
  }

  public void setPointsDescription(String pointsDescription) {
    this.pointsDescription = pointsDescription;
  }

  public int getStarRating() {
    return starRating;
  }

  public void setStarRating(int starRating) {
    this.starRating = starRating;
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

  public int getMaxQuantityPerOrder() {
    return maxQuantityPerOrder;
  }

  public void setMaxQuantityPerOrder(int maxQuantityPerOrder) {
    this.maxQuantityPerOrder = maxQuantityPerOrder;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public String getTextOnImage() {
    return textOnImage;
  }

  public void setTextOnImage(String textOnImage) {
    this.textOnImage = textOnImage;
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

  public List<ProductPicture> getProductPictures() {
    return productPictures;
  }

  public void setProductPictures(List<ProductPicture> productPictures) {
    this.productPictures = productPictures;
  }

  public String getCurrencyLabel() {
    return currencyLabel;
  }

  public void setCurrencyLabel(String currencyLabel) {
    this.currencyLabel = currencyLabel;
  }
}
