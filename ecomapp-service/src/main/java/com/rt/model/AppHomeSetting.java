package com.rt.model;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

/**
 * Collection to store App Home Settings
 */
@Document(collection = "appHomeSetting")
public class AppHomeSetting {

  @Id
  private String id;
  //Fields for App Header
  private String appLogoText;
  private String appLogoTextLink;
  //Fields for AppSubHeader
  private String appSubHeaderImageFileName;
  @Transient
  private MultipartFile appSubHeaderNewImageFile;//No need to store file handle in MongoDB
  private String appSubHeaderImageText1;
  private String appSubHeaderImageText2;
  private String appSubHeaderImageButtonText;
  //Sub Footer - contact section
  private String contactHeaderText;
  private String contactSectionText;
  //Sub Footer - About Section
  private String aboutHeaderText;
  private String aboutSectionText1;
  private String aboutSectionLink1;
  private String aboutSectionText2;
  private String aboutSectionLink2;
  private String aboutSectionText3;
  private String aboutSectionLink3;
  private String aboutSectionText4;
  private String aboutSectionLink4;
  private String aboutSectionText5;
  private String aboutSectionLink5;
  private String aboutSectionText6;
  private String aboutSectionLink6;
  private String aboutSectionText7;
  private String aboutSectionLink7;
  private String aboutSectionText8;
  private String aboutSectionLink8;
  private String aboutSectionText9;
  private String aboutSectionLink9;
  //Sub Footer - Store section
  private String storeHeaderText;
  private String companyLocation;
  private String companyPhoneNumber;
  private String companyEmailId;
  //Sub Footer We Accept Section
  private String weAcceptHeaderText;
  private String weAccept1;
  private String weAccept2;
  //Sub Footer - Social network links
  private String faceBookLink;
  private String instagramLink;
  private String snapchatLink;
  private String pintrestLink;
  private String twitterLink;
  private String linkedInLink;
  private String youtubeLink;
  //App Footer
  private String currentYear;
  private String footerText;
  //Audit information
  private DateTime modifiedDate;
  private String modifiedBy;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getAppLogoText() {
    return appLogoText;
  }

  public void setAppLogoText(String appLogoText) {
    this.appLogoText = appLogoText;
  }

  public String getAppLogoTextLink() {
    return appLogoTextLink;
  }

  public void setAppLogoTextLink(String appLogoTextLink) {
    this.appLogoTextLink = appLogoTextLink;
  }

  public String getAppSubHeaderImageFileName() {
    return appSubHeaderImageFileName;
  }

  public void setAppSubHeaderImageFileName(String appSubHeaderImageFileName) {
    this.appSubHeaderImageFileName = appSubHeaderImageFileName;
  }

  public MultipartFile getAppSubHeaderNewImageFile() {
    return appSubHeaderNewImageFile;
  }

  public void setAppSubHeaderNewImageFile(
      MultipartFile appSubHeaderNewImageFile) {
    this.appSubHeaderNewImageFile = appSubHeaderNewImageFile;
  }

  public String getAppSubHeaderImageText1() {
    return appSubHeaderImageText1;
  }

  public void setAppSubHeaderImageText1(String appSubHeaderImageText1) {
    this.appSubHeaderImageText1 = appSubHeaderImageText1;
  }

  public String getAppSubHeaderImageText2() {
    return appSubHeaderImageText2;
  }

  public void setAppSubHeaderImageText2(String appSubHeaderImageText2) {
    this.appSubHeaderImageText2 = appSubHeaderImageText2;
  }

  public String getAppSubHeaderImageButtonText() {
    return appSubHeaderImageButtonText;
  }

  public void setAppSubHeaderImageButtonText(String appSubHeaderImageButtonText) {
    this.appSubHeaderImageButtonText = appSubHeaderImageButtonText;
  }

  public String getContactHeaderText() {
    return contactHeaderText;
  }

  public void setContactHeaderText(String contactHeaderText) {
    this.contactHeaderText = contactHeaderText;
  }

  public String getContactSectionText() {
    return contactSectionText;
  }

  public void setContactSectionText(String contactSectionText) {
    this.contactSectionText = contactSectionText;
  }

  public String getAboutHeaderText() {
    return aboutHeaderText;
  }

  public void setAboutHeaderText(String aboutHeaderText) {
    this.aboutHeaderText = aboutHeaderText;
  }

  public String getAboutSectionText1() {
    return aboutSectionText1;
  }

  public void setAboutSectionText1(String aboutSectionText1) {
    this.aboutSectionText1 = aboutSectionText1;
  }

  public String getAboutSectionLink1() {
    return aboutSectionLink1;
  }

  public void setAboutSectionLink1(String aboutSectionLink1) {
    this.aboutSectionLink1 = aboutSectionLink1;
  }

  public String getAboutSectionText2() {
    return aboutSectionText2;
  }

  public void setAboutSectionText2(String aboutSectionText2) {
    this.aboutSectionText2 = aboutSectionText2;
  }

  public String getAboutSectionLink2() {
    return aboutSectionLink2;
  }

  public void setAboutSectionLink2(String aboutSectionLink2) {
    this.aboutSectionLink2 = aboutSectionLink2;
  }

  public String getAboutSectionText3() {
    return aboutSectionText3;
  }

  public void setAboutSectionText3(String aboutSectionText3) {
    this.aboutSectionText3 = aboutSectionText3;
  }

  public String getAboutSectionLink3() {
    return aboutSectionLink3;
  }

  public void setAboutSectionLink3(String aboutSectionLink3) {
    this.aboutSectionLink3 = aboutSectionLink3;
  }

  public String getAboutSectionText4() {
    return aboutSectionText4;
  }

  public void setAboutSectionText4(String aboutSectionText4) {
    this.aboutSectionText4 = aboutSectionText4;
  }

  public String getAboutSectionLink4() {
    return aboutSectionLink4;
  }

  public void setAboutSectionLink4(String aboutSectionLink4) {
    this.aboutSectionLink4 = aboutSectionLink4;
  }

  public String getAboutSectionText5() {
    return aboutSectionText5;
  }

  public void setAboutSectionText5(String aboutSectionText5) {
    this.aboutSectionText5 = aboutSectionText5;
  }

  public String getAboutSectionLink5() {
    return aboutSectionLink5;
  }

  public void setAboutSectionLink5(String aboutSectionLink5) {
    this.aboutSectionLink5 = aboutSectionLink5;
  }

  public String getAboutSectionText6() {
    return aboutSectionText6;
  }

  public void setAboutSectionText6(String aboutSectionText6) {
    this.aboutSectionText6 = aboutSectionText6;
  }

  public String getAboutSectionLink6() {
    return aboutSectionLink6;
  }

  public void setAboutSectionLink6(String aboutSectionLink6) {
    this.aboutSectionLink6 = aboutSectionLink6;
  }

  public String getAboutSectionText7() {
    return aboutSectionText7;
  }

  public void setAboutSectionText7(String aboutSectionText7) {
    this.aboutSectionText7 = aboutSectionText7;
  }

  public String getAboutSectionLink7() {
    return aboutSectionLink7;
  }

  public void setAboutSectionLink7(String aboutSectionLink7) {
    this.aboutSectionLink7 = aboutSectionLink7;
  }

  public String getAboutSectionText8() {
    return aboutSectionText8;
  }

  public void setAboutSectionText8(String aboutSectionText8) {
    this.aboutSectionText8 = aboutSectionText8;
  }

  public String getAboutSectionLink8() {
    return aboutSectionLink8;
  }

  public void setAboutSectionLink8(String aboutSectionLink8) {
    this.aboutSectionLink8 = aboutSectionLink8;
  }

  public String getAboutSectionText9() {
    return aboutSectionText9;
  }

  public void setAboutSectionText9(String aboutSectionText9) {
    this.aboutSectionText9 = aboutSectionText9;
  }

  public String getAboutSectionLink9() {
    return aboutSectionLink9;
  }

  public void setAboutSectionLink9(String aboutSectionLink9) {
    this.aboutSectionLink9 = aboutSectionLink9;
  }

  public String getStoreHeaderText() {
    return storeHeaderText;
  }

  public void setStoreHeaderText(String storeHeaderText) {
    this.storeHeaderText = storeHeaderText;
  }

  public String getCompanyLocation() {
    return companyLocation;
  }

  public void setCompanyLocation(String companyLocation) {
    this.companyLocation = companyLocation;
  }

  public String getCompanyPhoneNumber() {
    return companyPhoneNumber;
  }

  public void setCompanyPhoneNumber(String companyPhoneNumber) {
    this.companyPhoneNumber = companyPhoneNumber;
  }

  public String getCompanyEmailId() {
    return companyEmailId;
  }

  public void setCompanyEmailId(String companyEmailId) {
    this.companyEmailId = companyEmailId;
  }

  public String getWeAcceptHeaderText() {
    return weAcceptHeaderText;
  }

  public void setWeAcceptHeaderText(String weAcceptHeaderText) {
    this.weAcceptHeaderText = weAcceptHeaderText;
  }

  public String getWeAccept1() {
    return weAccept1;
  }

  public void setWeAccept1(String weAccept1) {
    this.weAccept1 = weAccept1;
  }

  public String getWeAccept2() {
    return weAccept2;
  }

  public void setWeAccept2(String weAccept2) {
    this.weAccept2 = weAccept2;
  }

  public String getFaceBookLink() {
    return faceBookLink;
  }

  public void setFaceBookLink(String faceBookLink) {
    this.faceBookLink = faceBookLink;
  }

  public String getInstagramLink() {
    return instagramLink;
  }

  public void setInstagramLink(String instagramLink) {
    this.instagramLink = instagramLink;
  }

  public String getSnapchatLink() {
    return snapchatLink;
  }

  public void setSnapchatLink(String snapchatLink) {
    this.snapchatLink = snapchatLink;
  }

  public String getPintrestLink() {
    return pintrestLink;
  }

  public void setPintrestLink(String pintrestLink) {
    this.pintrestLink = pintrestLink;
  }

  public String getTwitterLink() {
    return twitterLink;
  }

  public void setTwitterLink(String twitterLink) {
    this.twitterLink = twitterLink;
  }

  public String getLinkedInLink() {
    return linkedInLink;
  }

  public void setLinkedInLink(String linkedInLink) {
    this.linkedInLink = linkedInLink;
  }

  public String getCurrentYear() {
    return currentYear;
  }

  public void setCurrentYear(String currentYear) {
    this.currentYear = currentYear;
  }

  public String getFooterText() {
    return footerText;
  }

  public void setFooterText(String footerText) {
    this.footerText = footerText;
  }

  public DateTime getModifiedDate() {
    return modifiedDate;
  }

  public void setModifiedDate(DateTime modifiedDate) {
    this.modifiedDate = modifiedDate;
  }

  public String getModifiedBy() {
    return modifiedBy;
  }

  public void setModifiedBy(String modifiedBy) {
    this.modifiedBy = modifiedBy;
  }

  public String getYoutubeLink() {
    return youtubeLink;
  }

  public void setYoutubeLink(String youtubeLink) {
    this.youtubeLink = youtubeLink;
  }
}
