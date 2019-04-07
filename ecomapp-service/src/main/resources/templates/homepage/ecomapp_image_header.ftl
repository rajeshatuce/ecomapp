<#macro ecomapp_image_header>
    <div class="w3-display-container w3-container ecomapp-margin-top-28px">
      <img src="${CDN_IMG_URL}${APP_HOME_SETTING.appSubHeaderImageFileName}" style="width:100%">
      <div class="w3-display-topleft w3-text-white" style="padding:24px 48px">
        <h1 class="w3-jumbo w3-hide-small">${APP_HOME_SETTING.appSubHeaderImageText1}</h1>
        <h1 class="w3-hide-large w3-hide-medium">${APP_HOME_SETTING.appSubHeaderImageText1}</h1>
        <h1 class="w3-hide-small">${APP_HOME_SETTING.appSubHeaderImageText2}</h1>
        <p><a href="#products"
              class="w3-button w3-black w3-padding-large w3-large w3-ripple shopNowBtn">${APP_HOME_SETTING.appSubHeaderImageButtonText}</a>
        </p>
      </div>
    </div>
</#macro>