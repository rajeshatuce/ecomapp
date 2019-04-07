<#macro ecomapp_setting_home>
  <div class="w3-container">
    <form action="#" name="appHomeSettingForm">
      <div class="w3-card-4 w3-padding ecomapp-margin-top-28px w3-margin-bottom">
        <div class="w3-container w3-brown">
          <h6>Application Header</h6>
        </div>
        <p>
          <label class="w3-text-brown"><b>Application LOGO Text*</b></label>
          <input class="w3-input w3-border" name="appLogoText" type="text" maxlength="10"
                 ng-model="appHomeSetting.appLogoText" required>
          <input type="hidden" name="id" value="{{appHomeSetting.id}}">
        </p>
        <p>
          <label class="w3-text-brown"><b>Application Logo Text Link*</b></label>
          <input class="w3-input w3-border" name="appLogoTextLink" type="text"
                 ng-model="appHomeSetting.appLogoTextLink" required>
        </p>
      </div>
      <div class="w3-card-4 w3-padding ecomapp-margin-top-28px w3-margin-bottom">
        <div class="w3-container w3-brown">
          <h6>Application Sub Header</h6>
        </div>
        <p>
          <label class="w3-text-brown"><b>Image File Name:</b><span>{{appHomeSetting.appSubHeaderImageFileName}}</span></label>
          <input id="appSubHeaderImageFile" class="w3-input w3-border" name="appSubHeaderImageFile"
                 type="file" file-model="appHomeSetting.appSubHeaderNewImageFile" accept="image/*">
        </p>
        <p>
          <label class="w3-text-brown"><b>Image Text 1*</b></label>
          <input class="w3-input w3-border" name="appSubHeaderImageText1" type="text" maxlength="15"
                 ng-model="appHomeSetting.appSubHeaderImageText1">
        </p>
        <p>
          <label class="w3-text-brown"><b>Image Text 2*</b></label>
          <input class="w3-input w3-border" name="appSubHeaderImageText2" type="text" maxlength="20"
                 ng-model="appHomeSetting.appSubHeaderImageText2">
        </p>
        <p>
          <label class="w3-text-brown"><b>Image Button Text*</b></label>
          <input class="w3-input w3-border" name="appSubHeaderImageButtonText" type="text"
                 maxlength="15" ng-model="appHomeSetting.appSubHeaderImageButtonText" required>
        </p>
      </div>
      <div class="w3-card-4 w3-padding ecomapp-margin-top-28px w3-margin-bottom">
        <div class="w3-container w3-brown">
          <h6>Application Sub Footer: Contact Section</h6>
        </div>
        <p>
          <label class="w3-text-brown"><b>Contact Header Text*</b></label>
          <input class="w3-input w3-border" name="contactHeaderText" type="text" maxlength="15"
                 ng-model="appHomeSetting.contactHeaderText" required>
        </p>
        <p>
          <label class="w3-text-brown"><b>Contact Section Text*</b></label>
          <input class="w3-input w3-border" name="contactSectionText" type="text" maxlength="25"
                 ng-model="appHomeSetting.contactSectionText" required>
        </p>
      </div>

      <div class="w3-card-4 w3-padding ecomapp-margin-top-28px w3-margin-bottom">
        <div class="w3-container w3-brown">
          <h6>Application Sub Footer: About Section</h6>
        </div>
        <p>
          <label class="w3-text-brown"><b>About Header Text*</b></label>
          <input class="w3-input w3-border" name="aboutHeaderText" type="text" maxlength="15"
                 ng-model="appHomeSetting.aboutHeaderText" required>
        </p>
        <div>
          <label class="w3-text-brown"><b>About Section Links*</b></label>
          <div class="w3-responsive">
            <table class="w3-table-all">
              <thead>
              <tr class="w3-brown">
                <th>Text</th>
                <th>Links</th>
              </tr>
              </thead>
              <tr>
                <td><input class="w3-input w3-border" type="text" maxlength="15"
                           ng-model="appHomeSetting.aboutSectionText1" required></td>
                <td><input class="w3-input w3-border" type="text"
                           ng-model="appHomeSetting.aboutSectionLink1" required></td>
              </tr>
              <tr>
                <td><input class="w3-input w3-border" type="text" maxlength="15"
                           ng-model="appHomeSetting.aboutSectionText2" required></td>
                <td><input class="w3-input w3-border" type="text"
                           ng-model="appHomeSetting.aboutSectionLink2" required></td>
              </tr>
              <tr>
                <td><input class="w3-input w3-border" type="text" maxlength="15"
                           ng-model="appHomeSetting.aboutSectionText3" required></td>
                <td><input class="w3-input w3-border" type="text"
                           ng-model="appHomeSetting.aboutSectionLink3" required></td>
              </tr>
              <tr>
                <td><input class="w3-input w3-border" type="text" maxlength="15"
                           ng-model="appHomeSetting.aboutSectionText4" required></td>
                <td><input class="w3-input w3-border" type="text"
                           ng-model="appHomeSetting.aboutSectionLink4" required></td>
              </tr>
              <tr>
                <td><input class="w3-input w3-border" type="text" maxlength="15"
                           ng-model="appHomeSetting.aboutSectionText5" required></td>
                <td><input class="w3-input w3-border" type="text"
                           ng-model="appHomeSetting.aboutSectionLink5" required></td>
              </tr>
              <tr>
                <td><input class="w3-input w3-border" type="text" maxlength="15"
                           ng-model="appHomeSetting.aboutSectionText6" required></td>
                <td><input class="w3-input w3-border" type="text"
                           ng-model="appHomeSetting.aboutSectionLink6" required></td>
              </tr>
              <tr>
                <td><input class="w3-input w3-border" type="text" maxlength="15"
                           ng-model="appHomeSetting.aboutSectionText7" required></td>
                <td><input class="w3-input w3-border" type="text"
                           ng-model="appHomeSetting.aboutSectionLink7" required></td>
              </tr>
              <tr>
                <td><input class="w3-input w3-border" type="text" maxlength="15"
                           ng-model="appHomeSetting.aboutSectionText8" required></td>
                <td><input class="w3-input w3-border" type="text"
                           ng-model="appHomeSetting.aboutSectionLink8" required></td>
              </tr>
              <tr>
                <td><input class="w3-input w3-border" type="text" maxlength="15"
                           ng-model="appHomeSetting.aboutSectionText9" required></td>
                <td><input class="w3-input w3-border" type="text"
                           ng-model="appHomeSetting.aboutSectionLink9" required></td>
              </tr>
            </table>
          </div>
        </div>
      </div>

      <div class="w3-card-4 w3-padding ecomapp-margin-top-28px w3-margin-bottom">
        <div class="w3-container w3-brown">
          <h6>Application Sub Footer: Store Section</h6>
        </div>
        <p>
          <label class="w3-text-brown"><b>Store Header Text*</b></label>
          <input class="w3-input w3-border" name="companyLocation" type="text" maxlength="15"
                 ng-model="appHomeSetting.storeHeaderText" required>
        </p>
        <p>
          <label class="w3-text-brown"><b>Company Location*</b></label>
          <input class="w3-input w3-border" name="companyLocation" type="text" maxlength="15"
                 ng-model="appHomeSetting.companyLocation" required>
        </p>
        <p>
          <label class="w3-text-brown"><b>Company Phone Number*</b></label>
          <input class="w3-input w3-border" name="companyPhoneNumber" type="text" maxlength="15"
                 ng-model="appHomeSetting.companyPhoneNumber" required>
        </p>
        <p>
          <label class="w3-text-brown"><b>Company Email ID*</b></label>
          <input class="w3-input w3-border" name="companyEmailId" type="email" maxlength="25"
                 ng-model="appHomeSetting.companyEmailId" required>
        </p>
      </div>

      <div class="w3-card-4 w3-padding ecomapp-margin-top-28px w3-margin-bottom">
        <div class="w3-container w3-brown">
          <h6>Application Sub Footer: We Accept</h6>
        </div>
        <p>
          <label class="w3-text-brown"><b>Header Text*</b></label>
          <input class="w3-input w3-border" name="weAcceptHeaderText" type="text" maxlength="15"
                 ng-model="appHomeSetting.weAcceptHeaderText" required>
        </p>
        <p>
          <label class="w3-text-brown"><b>We Accept Text 1*</b></label>
          <input class="w3-input w3-border" name="weAccept1" type="text" maxlength="15"
                 ng-model="appHomeSetting.weAccept1" required>
        </p>
        <p>
          <label class="w3-text-brown"><b>We Accept Text 2*</b></label>
          <input class="w3-input w3-border" name="weAccept2" type="text" maxlength="15"
                 ng-model="appHomeSetting.weAccept2" required>
        </p>
      </div>

      <div class="w3-card-4 w3-padding ecomapp-margin-top-28px w3-margin-bottom">
        <div class="w3-container w3-brown">
          <h6>Application Sub Footer: Social Network Links</h6>
        </div>
        <p>
          <label class="w3-text-brown"><b>Facebook Link*</b></label>
          <input class="w3-input w3-border" name="faceBookLink" type="text"
                 ng-model="appHomeSetting.faceBookLink" required>
        </p>
        <p>
          <label class="w3-text-brown"><b>Instagram Link*</b></label>
          <input class="w3-input w3-border" name="instagramLink" type="text"
                 ng-model="appHomeSetting.instagramLink" required>
        </p>
        <p>
          <label class="w3-text-brown"><b>Snapchat Link*</b></label>
          <input class="w3-input w3-border" name="snapchatLink" type="text"
                 ng-model="appHomeSetting.snapchatLink" required>
        </p>
        <p>
          <label class="w3-text-brown"><b>Pintrest Link*</b></label>
          <input class="w3-input w3-border" name="pintrestLink" type="text"
                 ng-model="appHomeSetting.pintrestLink" required>
        </p>
        <p>
          <label class="w3-text-brown"><b>Twitter Link*</b></label>
          <input class="w3-input w3-border" name="twitterLink" type="text"
                 ng-model="appHomeSetting.twitterLink" required>
        </p>
        <p>
          <label class="w3-text-brown"><b>LinkedIn Link*</b></label>
          <input class="w3-input w3-border" name="linkedInLink" type="text"
                 ng-model="appHomeSetting.linkedInLink" required>
        </p>
        <p>
          <label class="w3-text-brown"><b>YouTube Link*</b></label>
          <input class="w3-input w3-border" name="youtubeLink" type="text"
                 ng-model="appHomeSetting.youtubeLink" required>
        </p>
      </div>

      <div class="w3-card-4 w3-padding ecomapp-margin-top-28px w3-margin-bottom">
        <div class="w3-container w3-brown">
          <h6>Application Footer</h6>
        </div>
        <p>
          <label class="w3-text-brown"><b>Current Year*</b></label>
          <input class="w3-input w3-border" name="currentYear" type="text" maxlength="4"
                 ng-model="appHomeSetting.currentYear" required>
        </p>
        <p>
          <label class="w3-text-brown"><b>Footer Text*</b></label>
          <input class="w3-input w3-border" name="footerText" type="text" maxlength="30"
                 ng-model="appHomeSetting.footerText" required>
        </p>
      </div>
      <div class="w3-card-4 w3-padding ecomapp-margin-top-28px w3-margin-bottom">
        <div class="w3-container w3-brown">
          <h6>Audit Information</h6>
        </div>
        <p>
          <label class="w3-text-brown"><b>Last Modified By:</b>{{appHomeSetting.modifiedBy}}</label>
        </p>
        <p>
          <label class="w3-text-brown"><b>Last Modified Time:</b>{{appHomeSetting.modifiedDateFormatted}}</label>
        </p>
      </div>
      <div class="w3-center w3-margin">
        <button
            class="w3-btn w3-margin-top w3-round-xxlarge w3-red w3-hover-green w3-ripple fa fa-thumbs-up"
            ng-click="saveHomePageSetting($event)">Save Details
        </button>
      </div>
    </form>
  </div>

</#macro>