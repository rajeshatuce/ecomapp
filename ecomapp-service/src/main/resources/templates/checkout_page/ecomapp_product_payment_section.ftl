<#macro ecomapp_product_payment_section>
  <!-- Products Selected Table-->
  <div class="w3-container">
    <div class="w3-panel w3-border-bottom ecomapp-margin-top-28px">
      <#assign noOfProducts = Order.productsOrdered?size>
      <h5><i class="fa fa-shopping-cart"></i>Your Cart( ${noOfProducts} items )</h5>
    </div>
    <!-- Products Added in Cart Table-->
    <div class="w3-responsive w3-card-4">
      <table class="w3-table-all w3-small">
        <thead>
        <tr class="w3-dark-grey">
          <th>ITEM IMAGE</th>
          <th>ITEM NAME</th>
          <th>UNIT PRICE</th>
          <th>QUANTITY</th>
          <th>SUB TOTAL</th>
          <th class="w3-lime">SAVINGS</th>
        </tr>
        </thead>
        <tbody>
          <#list Order.productsOrdered as product>
          <tr>
            <td><img src="${CDN_IMG_URL}${product.uniqueFileName}"
                   class="w3-col s3 w3-circle w3-padding-small mycartIcon"></td>
            <td><b>${product.name}</b></td>
            <td>
              <div>${product.currencyLabel} ${product.currentUnitPrice}</div>
              <div class="w3-text-gray">
                <s>${product.currencyLabel} ${product.previousUnitPrice} </s></div>
            </td>
            <td>${product.selectedQuantity}</td>
            <td class="w3-border-right">${product.currencyLabel} ${product.formattedSubTotal}</td>
            <td class="w3-text-red">${product.currencyLabel} ${product.formattedSavingsAmount}</td>
          </tr>
          </#list>
        </tbody>
      </table>
    </div>
    <!-- Empty Cart and Total Amount-->
    <div class="w3-row">
      <div class="w3-quarter w3-section w3-padding-small">
        <#if ORDER_PAGE>
          <div class="stamp">
            <span>${Order.paymentType}</span><br>${Order.orderId}
          </div>
        </#if>
      </div>
      <div class="w3-threequarter">
        <div class="w3-card-4 w3-border w3-round-large w3-right w3-section w3-padding-small">
          <div class="w3-row">
            <div class="w3-container w3-twothird w3-border-right">
              <div class="w3-border-bottom">
                <div class="w3-row">
                  <div class="w3-half">
                    <p class="w3-small">Subtotal</p>
                  </div>
                  <div class="w3-half">
                    <p class="w3-small">${Order.currencyLabel} ${Order.formattedSubTotal}</p>
                  </div>
                </div>
                <div class="w3-row">
                  <div class="w3-half">
                    <p class="w3-small">Delivery Charges</p>
                  </div>
                  <div class="w3-half">
                    <p class="w3-small">${Order.currencyLabel} ${Order.formattedDeliveryChanges}</p>
                  </div>
                </div>
              </div>
              <div class="w3-row">
                <div class="w3-half">
                  <p><b>TOTAL</b></p>
                </div>
                <div class="w3-half">
                  <p><b>${Order.currencyLabel} ${Order.formattedTotalCharges}</b></p>
                </div>
              </div>
            </div>
            <div class="w3-container w3-third">
              <p class="w3-medium">You Saved!</p>
              <div class="w3-padding-small w3-red w3-circle w3-center">
                <p class="w3-medium">${Order.currencyLabel} ${Order.formattedTotalSavings}</p>
              </div>
            </div>
          </div>

        </div>
      </div>
    </div>

  </div>
  <!-- Delivery Address Section-->
  <div class="w3-container">
    <div class="w3-panel w3-border-bottom ecomapp-margin-top-28px">
      <h5><i class="fa fa-truck"></i>Delivery Address</h5>
    </div>
    <div class="w3-row">
      <div class="w3-right">
        <#if !ORDER_PAGE>
          <button
              class="w3-btn w3-white w3-border w3-border-red w3-round-large w3-ripple fa fa-plus-square"
              ng-click="onClickAddNewAddressButton($event)">ADD
            NEW ADDRESS
          </button>
        </#if>
      </div>
    </div>
    <#if !ORDER_PAGE>
      <div class="w3-row" id="customerAddressSection" data-ng-init="fetchCustomerAddress()">
        <div class="w3-card-4 w3-col l3 s6 w3-margin customerAddressMinWidth"
             ng-repeat="a in newAddressAdded track by $index">
          <header class="w3-container w3-light-grey">
            <h4>{{a.customerAddressType}}</h4>
          </header>
          <div class="w3-container">
            <div class="w3-row">
              <div class="w3-right">
                <i class="fa fa-check-square-o w3-green w3-xxlarge"
                   ng-show="a.selectedForDelivery"></i>
              </div>
            </div>
            <div class="w3-row">
              <div class="w3-container">
                <p class="w3-medium">{{a.deliveryFullName}},
                  {{a.address1}},
                  {{a.address2}},
                  {{a.landmark}},
                  {{a.townCity}},
                  {{a.state}} - {{a.pincode}},
                  Phone: {{a.mobileNumber}}</p>
              </div>
            </div>
          </div>
          <button class="w3-button w3-block w3-ripple w3-dark-grey"
                  ng-click="setSelectedForDelivery(a.customerAddressId)">DELIVER HERE
          </button>
        </div>
      </div>
    <#else>
      <div class="w3-row" id="customerAddressSection">
        <div class="w3-card-4 w3-col l3 s6 w3-margin customerAddressMinWidth">
          <header class="w3-container w3-light-grey">
            <h4>${Order.orderDeliveryAddress.customerAddressType}</h4>
          </header>
          <div class="w3-container">
            <div class="w3-row">
              <div class="w3-right">
                <i class="fa fa-check-square-o w3-green w3-xxlarge"
                ></i>
              </div>
            </div>
            <div class="w3-row">
              <div class="w3-container">
                <p class="w3-medium">${Order.orderDeliveryAddress.deliveryFullName},
                  ${Order.orderDeliveryAddress.address1},
                  ${Order.orderDeliveryAddress.address2},
                  ${Order.orderDeliveryAddress.landmark},
                  ${Order.orderDeliveryAddress.townCity},
                  ${Order.orderDeliveryAddress.state} - ${Order.orderDeliveryAddress.pincode},
                  Phone: ${Order.orderDeliveryAddress.mobileNumber}</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </#if>
  </div>

  <!-- Payment Options-->
  <div class="w3-container">
    <div class="w3-panel w3-border-bottom ecomapp-margin-top-28px">
      <h5><i class="fa fa-money"></i>Payment Options</h5>
    </div>
    <div class="w3-card-4 w3-border w3-round-large w3-light-grey w3-section w3-padding-small"
         ng-init="paymentOptions='Cash_On_Delivery'">
      <p>
        <input class="w3-radio" type="radio" ng-model="paymentOptions" name="paymentOptions"
               value="Cash_On_Delivery">
        <label><i class="fa fa-rupee"></i>Cash on Delivery</label></p>
      <p>
        <input class="w3-radio" type="radio" ng-model="paymentOptions" name="paymentOptions"
               value="Credit_Card_Net_Banking" disabled>
        <label><i class="fa fa-credit-card"></i>Card/NetBanking</label></p>
    </div>

  </div>
  <!-- Place Order/ Cancel Order button-->
  <div class="w3-container ecomapp-margin-top-28px w3-margin-bottom">
    <div class="w3-row w3-center">
      <#if ORDER_PAGE>
        <button class="w3-btn w3-white w3-border w3-round-xxlarge w3-ripple fa fa-thumbs-down">
          Cancel Order
        </button>
      <#else>
        <form class="ecomapp-displayinline" action="/createOrderForCustomer" name="createOrderForm"
              method="post" novalidate>
          <input id="productsToPlaceOrder" type="hidden" name="productsToPlaceOrder"
                 value='${SHOPPING_CART_VALUE}' required/>
          <input id="deliveryAddressId" type="hidden" name="deliveryAddressId"
                 value="{{deliveryAddressId}}" required/>
          <input id="selectedPaymentOptions" type="hidden" name="selectedPaymentOptions"
                 value="{{paymentOptions}}" required/>
          <button class="w3-btn w3-round-xxlarge w3-red w3-hover-green w3-ripple fa fa-thumbs-up"
                  ng-disabled="createOrderForm.$invalid" ng-click="onPlaceOrderClick($event)">Place
            Order
          </button>
        </form>
      </#if>
    </div>
  </div>

</#macro>