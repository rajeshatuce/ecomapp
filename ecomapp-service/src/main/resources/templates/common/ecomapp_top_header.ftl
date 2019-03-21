<#macro ecomapp_top_header>
  <header class="fixed-top w3-container w3-xlarge w3-border-bottom">
    <div class="w3-col s4 w3-center"><p class="w3-left"><b>LOGO</b></p></div>
    <div class="w3-col s4 w3-center"><p><input id="search" class="ecom-search" type="text"
                                               name="search" placeholder="Search..">
      <i class="fa fa-search w3-hover-opacity"></i></p>
    </div>
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
            <a href="#" class="w3-border-bottom">My Account</a>
            <a href="myOrders" class="w3-border-bottom">My Orders</a>
            <a href="#" class="w3-border-bottom">Customer Service</a>
            <a href="/" class="w3-border-bottom" ng-click="logout()">Logout</a>
          </div>
        </div>

        <div class="dropdown" style="display:inline;">
          <i class="fa fa-shopping-cart w3-hover-opacity dropbtn"></i>
          <span
              class="w3-badge w3-small w3-right w3-black">{{shoppingCart.totalProductCount}}</span>
          <div class="dropdown-content  w3-hover-shadow w3-border topHeaderMenuPositionFix">
            <div class="w3-row">
              <div class="w3-container mycart">
                <ul class="w3-ul w3-card-4">
                  <li class="w3-bar" ng-repeat="x in shoppingCart.products track by $index">
                    <span ng-click="onRemoveProductFromShoppingCart($event, x.productId)"
                          class="w3-col s1 w3-button w3-white w3-xlarge w3-right">×</span>
                    <img ng-src="{{x.thumbNail}}"
                         class="w3-col s3 w3-circle w3-padding-small mycartIcon">
                    <div class="w3-col s3 w3-padding-small">
                      <span class="w3-small"><b>{{x.productName}}</b></span><br>
                      <span class="w3-tiny w3-text-gray">{{x.selectedQuantity}} X {{x.currentUnitPrice}}</span>
                    </div>
                    <div class="w3-col s2 w3-padding-small">
                      <span class="w3-small">
                        <select class="w3-select" name="quantity" ng-model="x.selectedQuantity"
                                ng-change="onShoppingCartQuantityChange()">
                          <option
                              ng-repeat="temp in [].constructor(x.maxQuantityPerOrder) track by $index"
                              value="{{$index+1}}">{{$index+1}}
                          </option>
                        </select>
                      </span>
                    </div>
                    <div class="w3-col s3 w3-padding-small">
                      <span class="w3-small">{{shoppingCart.currencyLabel}} {{x.subTotal}}</span>
                    </div>


                  </li>
                </ul>
              </div>
            </div>
            <div class="w3-row w3-right">
              <form id="shoppingCartForm" action="/checkout" method="get">
                <input id="shoppingCartValue" name="shoppingCartValue" type="hidden" value=""/>
                <button type="button" class="payment_button" ng-click="checkoutShoppingCart()">
                  <span>Rs. {{shoppingCart.total}}</span></button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </header>
</#macro>

