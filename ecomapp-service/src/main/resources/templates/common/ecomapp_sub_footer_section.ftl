<#macro ecomapp_sub_footer_section>
  <footer class="w3-padding-64 w3-light-grey w3-small w3-center" id="footer">
    <div class="w3-row-padding">
      <div class="w3-col s4">
        <h4>${APP_HOME_SETTING.contactHeaderText}</h4>
        <p>${APP_HOME_SETTING.contactSectionText}</p>
        <form action="#" name="customerQueryForm">
          <div class="w3-panel w3-round-xxlarge w3-border" ng-class="customerQueryStatusCSS"
               ng-show="postCustomerQueryStatus">
            <p><i class="fa fa-check"></i>{{customerQueryStatusMessage}}</p>
          </div>
          <p ng-if="!user"><input class="w3-input w3-border" type="text" placeholder="Name"
                                  name="Name" ng-model="customerQuery.name" required>
          </p>
          <p ng-if="!user"><input class="w3-input w3-border" type="email" placeholder="Email"
                                  name="Email" ng-model="customerQuery.email"
                                  required></p>
          <p><input class="w3-input w3-border" type="text" placeholder="Subject" name="Subject"
                    ng-model="customerQuery.subject"
                    required></p>
          <p><input class="w3-input w3-border" type="text" placeholder="Message" name="Message"
                    ng-model="customerQuery.message"
                    required></p>
          <button class="w3-button w3-block w3-ripple w3-black"
                  ng-disabled="customerQueryForm.$invalid" ng-click="onPostCustomerQuery($event)">
            Send
          </button>
        </form>
      </div>

      <div class="w3-col s4">
        <h4>${APP_HOME_SETTING.aboutHeaderText}</h4>
        <p><a href="${APP_HOME_SETTING.aboutSectionLink1}">${APP_HOME_SETTING.aboutSectionText1}</a>
        </p>
        <p><a href="${APP_HOME_SETTING.aboutSectionLink2}">${APP_HOME_SETTING.aboutSectionText2}</a>
        </p>
        <p><a href="${APP_HOME_SETTING.aboutSectionLink3}">${APP_HOME_SETTING.aboutSectionText3}</a>
        </p>
        <p><a href="${APP_HOME_SETTING.aboutSectionLink4}">${APP_HOME_SETTING.aboutSectionText4}</a>
        </p>
        <p><a href="${APP_HOME_SETTING.aboutSectionLink5}">${APP_HOME_SETTING.aboutSectionText5}</a>
        </p>
        <p><a href="${APP_HOME_SETTING.aboutSectionLink6}">${APP_HOME_SETTING.aboutSectionText6}</a>
        </p>
        <p><a href="${APP_HOME_SETTING.aboutSectionLink7}">${APP_HOME_SETTING.aboutSectionText7}</a>
        </p>
        <p><a href="${APP_HOME_SETTING.aboutSectionLink8}">${APP_HOME_SETTING.aboutSectionText8}</a>
        </p>
        <p><a href="${APP_HOME_SETTING.aboutSectionLink9}">${APP_HOME_SETTING.aboutSectionText9}</a>
        </p>
      </div>

      <div class="w3-col s4 w3-justify">
        <h4>${APP_HOME_SETTING.storeHeaderText}</h4>
        <p><i class="fa fa-fw fa-map-marker"></i> ${APP_HOME_SETTING.companyLocation}</p>
        <p><i class="fa fa-fw fa-phone"></i> ${APP_HOME_SETTING.companyPhoneNumber}</p>
        <p><i class="fa fa-fw fa-envelope"></i> ${APP_HOME_SETTING.companyEmailId}</p>
        <h4>${APP_HOME_SETTING.weAcceptHeaderText}</h4>
        <p><i class="fa fa-fw fa-cc-amex"></i> ${APP_HOME_SETTING.weAccept1}</p>
        <p><i class="fa fa-fw fa-credit-card"></i> ${APP_HOME_SETTING.weAccept2}</p>
        <br>
        <a href="${APP_HOME_SETTING.faceBookLink}" target="_blank"><i
            class="fa fa-facebook-official w3-hover-opacity w3-large"></i></a>
        <a href="${APP_HOME_SETTING.instagramLink}" target="_blank"><i
            class="fa fa-instagram w3-hover-opacity w3-large"></i></a>
        <a href="${APP_HOME_SETTING.snapchatLink}" target="_blank"><i
            class="fa fa-snapchat w3-hover-opacity w3-large"></i></a>
        <a href="${APP_HOME_SETTING.pintrestLink}" target="_blank"><i
            class="fa fa-pinterest-p w3-hover-opacity w3-large"></i></a>
        <a href="${APP_HOME_SETTING.twitterLink}" target="_blank"><i
            class="fa fa-twitter w3-hover-opacity w3-large"></i></a>
        <a href="${APP_HOME_SETTING.linkedInLink}" target="_blank"><i
            class="fa fa-linkedin w3-hover-opacity w3-large"></i></a>
        <a href="${APP_HOME_SETTING.youtubeLink}" target="_blank"><i
            class="fa fa-youtube-play w3-hover-opacity w3-large"></i></a>
      </div>
    </div>
  </footer>
</#macro>