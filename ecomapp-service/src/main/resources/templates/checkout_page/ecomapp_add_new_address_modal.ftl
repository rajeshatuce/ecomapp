<#macro ecomapp_add_new_address_modal>
  <div id="addNewAddress" class="w3-modal">
    <div class="w3-modal-content w3-animate-zoom ecomapp-modal-padding">
      <div class="w3-container w3-white w3-center">
        <i onclick="document.getElementById('addNewAddress').style.display='none'"
           class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge ecomapp-color-white"></i>
        <div class="w3-card-4">
          <div class="w3-container w3-dark-grey">
            <h3 class="w3-left">Delivery Address</h3>
          </div>
          <form class="w3-container" action="#" name="addressForm" novalidate>
            <p>
              <label class="w3-left"><b>Address Type:*</b></label>
              <select class="w3-select w3-border" name="addressType" ng-model="customerAddressType"
                      required>
                <option value="" disabled selected>Choose your option</option>
                <option value="Home">Home</option>
                <option value="Office">Office</option>
                <option value="Other">Other</option>
              </select>
            <p>
              <label class="w3-left"><b>Full Name:*</b></label>
              <input class="w3-input w3-border" name="deliveryFullName" type="text"
                     ng-model="deliveryFullName" required></p>
            <p>
            <p>
              <label class="w3-left"><b>Mobile Number:*</b></label>
              <input class="w3-input w3-border" name="mobileNumber" ng-model="mobileNumber"
                     type="text" required></p>
            <p>
            <p>
              <label class="w3-left"><b>Pin Code:*</b></label>
              <input class="w3-input w3-border" name="pincode" type="text" ng-model="pincode"
                     required></p>
            <p>
            <p>
              <label class="w3-left"><b>Flat, House no., Building, Company, Apartment:*</b></label>
              <input class="w3-input w3-border" name="address1" type="text" ng-model="address1"
                     required></p>
            <p>
            <p>
              <label class="w3-left"><b>Area, Colony, Street, Sector, Village:*</b></label>
              <input class="w3-input w3-border" name="address2" type="text" ng-model="address2"
                     required></p>
            <p>
            <p>
              <label class="w3-left"><b>Landmark:*</b></label>
              <input class="w3-input w3-border" name="landmark" type="text" ng-model="landmark"
                     required></p>
            <p>
            <p>
              <label class="w3-left"><b>Town/City:*</b></label>
              <input class="w3-input w3-border" name="townCity" type="text" ng-model="townCity"
                     required></p>
            <p>
            <p>
              <label class="w3-left"><b>State:*</b></label>
              <input class="w3-input w3-border" name="state" type="text" ng-model="state" required>
            </p>
            <div class="w3-row w3-center w3-margin">
              <button class="w3-btn w3-white w3-border w3-round-xxlarge w3-ripple fa fa-close"
                      ng-click="clearAddNewAddressForm($event)">Clear
              </button>
              <button class="w3-btn w3-round-xxlarge w3-red w3-hover-green w3-ripple fa fa-check"
                      ng-disabled="addressForm.$invalid"
                      ng-click="onAddNewAddressOnSubmitClick($event)">
                Submit
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</#macro>