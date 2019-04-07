<#import "ecomapp_setting_home.ftl" as setting_home>
<#macro ecomapp_admin_body>
      <div class="w3-sidebar w3-bar-block w3-black w3-card" style="width:130px">
        <h5 class="w3-bar-item">Menu</h5>
        <button class="w3-bar-item w3-button tablink" ng-class="showHomePage ? 'w3-red': 'w3-black'"
                ng-click="showHomePage=true;showProducts=false;showOrders=false;showCustomerQuery=false;">
          Home Page
        </button>
        <button class="w3-bar-item w3-button tablink" ng-class="showProducts ? 'w3-red': 'w3-black'"
                ng-click="showHomePage=false;showProducts=true;showOrders=false;showCustomerQuery=false;">
          Products
        </button>
        <button class="w3-bar-item w3-button tablink" ng-class="showOrders ? 'w3-red': 'w3-black'"
                ng-click="showHomePage=false;showProducts=false;showOrders=true;showCustomerQuery=false;">
          Orders
        </button>
        <button class="w3-bar-item w3-button tablink"
                ng-class="showCustomerQuery ? 'w3-red': 'w3-black'"
                ng-click="showHomePage=false;showProducts=false;showOrders=false;showCustomerQuery=true;">
          Customer Query
        </button>
      </div>

      <div style="margin-left:130px">
        <div id="Home_Page" class="w3-container city w3-animate-opacity" ng-show="showHomePage">
          <!-- Home setting form below-->
          <@setting_home.ecomapp_setting_home/>
        </div>

        <div id="Products" class="w3-container city w3-animate-left" ng-show="showProducts">
          <p>Test</p>
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

      </div>
      <!-- Loading Overlay-->
      <div class="loading style-2" ng-show="showLoadingOverlay">
        <div class="loading-wheel"></div>
      </div>
</#macro>