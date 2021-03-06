<#import "ecomapp_setting_home.ftl" as setting_home>
<#import "ecomapp_setting_productGroup.ftl" as setting_productgroup>
<#import "ecomapp_setting_products.ftl" as setting_products>

<#macro ecomapp_admin_body>
      <div class="w3-sidebar w3-bar-block w3-black w3-card adminMenuWidth">
        <h5 class="w3-bar-item">Menu</h5>
        <button class="w3-bar-item w3-button tablink" ng-class="showHomePage ? 'w3-red': 'w3-black'"
                ng-click="showHomePage=true;showProducts=false;showOrders=false;showCustomerQuery=false;showuserRoleMapping=false;showProductGroup=false;">
          Home Page
        </button>
        <button class="w3-bar-item w3-button tablink"
                ng-class="showProductGroup ? 'w3-red': 'w3-black'"
                ng-click="showHomePage=false;showProductGroup=true;showProducts=false;showOrders=false;showuserRoleMapping=false;showCustomerQuery=false;">
          Product Group
        </button>
        <button class="w3-bar-item w3-button tablink" ng-class="showProducts ? 'w3-red': 'w3-black'"
                ng-click="showHomePage=false;showProducts=true;showOrders=false;showuserRoleMapping=false;showCustomerQuery=false;showProductGroup=false;">
          Products
        </button>
        <button class="w3-bar-item w3-button tablink" ng-class="showOrders ? 'w3-red': 'w3-black'"
                ng-click="showHomePage=false;showProducts=false;showOrders=true;showuserRoleMapping=false;showCustomerQuery=false;showProductGroup=false;">
          Orders
        </button>
        <button class="w3-bar-item w3-button tablink"
                ng-class="showCustomerQuery ? 'w3-red': 'w3-black'"
                ng-click="showHomePage=false;showProducts=false;showOrders=false;showuserRoleMapping=false;showCustomerQuery=true;showProductGroup=false;">
          Customer Query
        </button>
        <button class="w3-bar-item w3-button tablink"
                ng-class="showuserRoleMapping ? 'w3-red': 'w3-black'"
                ng-click="showHomePage=false;showProducts=false;showOrders=false;showCustomerQuery=false;showuserRoleMapping=true;showProductGroup=false;">
          User Role
        </button>
      </div>

      <div class="adminBodyMarginLeft">
        <div id="Home_Page" class="w3-container city w3-animate-opacity" ng-show="showHomePage">
          <!-- Home setting form below-->
          <@setting_home.ecomapp_setting_home/>
        </div>
        <div id="productGroup" class="w3-container city w3-animate-zoom" ng-show="showProductGroup">
          <!-- Product Group setting below-->
          <@setting_productgroup.ecomapp_setting_productGroup/>
        </div>
        <div id="Products" class="w3-container city w3-animate-left" ng-show="showProducts">
          <!-- Products setting below-->
          <@setting_products.ecomapp_setting_products/>
        </div>

        <div id="Orders" class="w3-container city w3-animate-top" ng-show="showOrders">
          <h2>Slide in from top</h2>
          <p>Tokyo is the capital of Japan.</p>
          <p>It is the center of the Greater Tokyo Area, and the most populous metropolitan area in
            the world.</p>
        </div>

        <div id="customerQuery" class="w3-container city w3-animate-right"
             ng-show="showCustomerQuery">
          <h2>Slide in from right</h2>
          <p>London is the capital city of England.</p>
          <p>It is the most populous city in the United Kingdom, with a metropolitan area of over 13
            million inhabitants.</p>
        </div>

        <div id="userRoleMapping" class="w3-container city w3-animate-bottom"
             ng-show="showuserRoleMapping">
          <h2>User Role Mapping</h2>
          <p>London is the capital city of England.</p>
          <p>It is the most populous city in the United Kingdom, with a metropolitan area of over 13
            million inhabitants.</p>
        </div>

      </div>
      <!-- Loading Overlay-->
      <div class="loading style-2" ng-show="showLoadingOverlay">
        <div class="loading-wheel"></div>
      </div>
</#macro>