<#macro ecomapp_admin_top_header>
  <header class="fixed-top w3-container w3-xlarge w3-border-bottom">
    <div class="w3-col s8 w3-center"><p class="w3-left"><b>LOGO</b></p></div>
    <div class="w3-col s4 w3-right topRightMenuPositionFix">
      <div class="w3-right header-rightdiv">
        <div class="dropdown" style="display:inline;">
          <i class='fas fa-user w3-hover-opacity'></i>
          <span class="ecomapp-hellouser"> Hi,
            <span id="shortUserName" ng-show="!user"> User</span>
            <span id="shortUserName"
                  ng-show="user"> {{user.userAuthentication.details.given_name}}</span>
          </span>
          <div class="dropdown-content w3-hover-shadow w3-border topHeaderMenuPositionFix"
               ng-show="!user">
            <a href="/" class="w3-border-bottom">Home</a>
            <a href="/google/login" class="w3-border-bottom">Login</a>
          </div>
          <div class="dropdown-content w3-hover-shadow w3-border topHeaderMenuPositionFix"
               ng-show="user">
            <a href="/" class="w3-border-bottom">Home</a>
            <a href="/" class="w3-border-bottom" ng-click="logout()">Logout</a>
          </div>
        </div>
      </div>
    </div>
  </header>
</#macro>

