<#macro ecomapp_footer>
  <div class="w3-black w3-center w3-padding-24">&copy;${APP_HOME_SETTING.currentYear}
    <a
        href="${APP_HOME_SETTING.appLogoTextLink}" title="${APP_HOME_SETTING.appLogoText}"
        target="_blank"
        class="w3-hover-opacity">${APP_HOME_SETTING.appLogoText}</a>
    ${APP_HOME_SETTING.footerText}
  </div>
</#macro>