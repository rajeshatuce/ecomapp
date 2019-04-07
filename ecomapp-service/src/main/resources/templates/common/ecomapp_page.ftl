<#macro ecomapp_page>
  <!DOCTYPE html>
  <html>
  <title>${APP_HOME_SETTING.appLogoText}</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
  <link rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link href='https://fonts.googleapis.com/css?family=Black+Ops+One' rel='stylesheet'
        type='text/css'>
  <link rel="stylesheet" href="${CDN_CSS_URL}ecomapp.css">
  <body ng-app="ecomapp" ng-controller="ecomappCtrl" ng-cloak>
  <#-- This processes the enclosed content:  -->
    <#nested>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
  <script src="${CDN_JS_URL}ecomapp.js"></script>
  <script src="${CDN_JS_URL}ecomapp_controller.js"></script>
  </body>
  </html>
</#macro>