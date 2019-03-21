<#macro ecomapp_product_payment_section>
  <!-- Products Selected Table-->
  <div class="w3-container">
    <div class="w3-panel w3-border-bottom ecomapp-margin-top-28px">
      <h5><i class="fa fa-shopping-cart"></i>Your Cart( 04 items )</h5>
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
        <button class="w3-btn w3-white w3-border w3-border-red w3-round-large w3-ripple fa fa-trash"
                onclick="document.getElementById('emptyCartModal').style.display='block'">EMPTY
          CART
        </button>
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
        <button
            class="w3-btn w3-white w3-border w3-border-red w3-round-large w3-ripple fa fa-plus-square"
            onclick="document.getElementById('addNewAddress').style.display='block'">ADD
          NEW ADDRESS
        </button>
      </div>
    </div>
    <div class="w3-row">
      <div class="w3-card-4 w3-col l3 s6 w3-margin" style="min-width: 230px;">
        <header class="w3-container w3-light-grey">
          <h4>Home Address</h4>
        </header>
        <div class="w3-container">
          <div class="w3-row">
            <div class="w3-right">
              <i class="fa fa-check-square-o w3-green w3-xxlarge"></i>
            </div>
          </div>
          <div class="w3-row">
            <div class="w3-container">
              <p class="w3-medium">Rajesh Tiwary,
                flat no:B-001, vandana tejyesh apartment,panathur main road,kadubesanhalli,near govt
                primary school.pin 560103,
                Ph: 8884278820</p>
            </div>
          </div>
        </div>
        <button class="w3-button w3-block w3-ripple w3-dark-grey">DELIVER HERE</button>
      </div>
      <div class="w3-card-4 w3-col l3 s6 w3-margin" style="min-width: 230px;">
        <header class="w3-container w3-light-grey">
          <h4>Office Address</h4>
        </header>
        <div class="w3-container">
          <div class="w3-row">
            <div class="w3-right">
            </div>
          </div>
          <div class="w3-row">
            <div class="w3-container">
              <p class="w3-medium">Goldman sachs pvt ltd,1st floor,crystal downs bldng,embassy
                golf links business park,intermediate ring road,domlur,
                BANGALORE, KARNATAKA 560071
                India
                Phone: 8884278820</p>
            </div>
          </div>
        </div>
        <button class="w3-button w3-block w3-ripple w3-dark-grey">DELIVER HERE</button>
      </div>
      <div class="w3-card-4 w3-col l3 s6 w3-margin" style="min-width: 230px;">
        <header class="w3-container w3-light-grey">
          <h4>Another Address</h4>
        </header>
        <div class="w3-container">
          <div class="w3-row">
            <div class="w3-right">
            </div>
          </div>
          <div class="w3-row">
            <div class="w3-container">
              <p class="w3-medium">Ram Janm Tiwary,
                Plot No-M/35, Phase-1,
                Chhend Colony, In front of JJM Market Complex,
                ROURKELA, ODISHA 769015
                India,
                Phone: 9937022900</p>
            </div>
          </div>
        </div>
        <button class="w3-button w3-block w3-ripple w3-dark-grey">DELIVER HERE</button>
      </div>
    </div>
  </div>

  <!-- Payment Options-->
  <div class="w3-container">
    <div class="w3-panel w3-border-bottom ecomapp-margin-top-28px">
      <h5><i class="fa fa-money"></i>Payment Options</h5>
    </div>
    <div class="w3-card-4 w3-border w3-round-large w3-light-grey w3-section w3-padding-small">
      <p>
        <input class="w3-radio" type="radio" name="paymentOptions" value="Cash_on_Delivery" checked>
        <label><i class="fa fa-rupee"></i>Cash on Delivery</label></p>
      <p>
        <input class="w3-radio" type="radio" name="paymentOptions" value="Card_NetBanking">
        <label><i class="fa fa-credit-card"></i>Card/NetBanking</label></p>
    </div>

  </div>
  <!-- Place Order/ Cancel Order button-->
  <div class="w3-container ecomapp-margin-top-28px w3-margin-bottom">
    <div class="w3-row w3-center">
      <button class="w3-btn w3-white w3-border w3-round-xxlarge w3-ripple fa fa-thumbs-down">Cancel
        Order
      </button>
      <button class="w3-btn w3-round-xxlarge w3-red w3-hover-green w3-ripple fa fa-thumbs-up">Place
        Order
      </button>
    </div>
  </div>

</#macro>