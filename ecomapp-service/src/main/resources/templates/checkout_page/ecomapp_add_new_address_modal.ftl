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
          <form class="w3-container" action="">
            <p>
              <label class="w3-left"><b>Address Type:</b></label>
              <select class="w3-select w3-border" name="addressType">
                <option value="" disabled selected>Choose your option</option>
                <option value="Home">Home</option>
                <option value="Office">Office</option>
                <option value="Other">Other</option>
              </select>
            <p>
              <label class="w3-left"><b>Full Name:</b></label>
              <input class="w3-input w3-border" name="fullName" type="text"></p>
            <p>
            <p>
              <label class="w3-left"><b>Mobile Number:</b></label>
              <input class="w3-input w3-border" name="mobileNumber" type="text"></p>
            <p>
            <p>
              <label class="w3-left"><b>Pin Code:</b></label>
              <input class="w3-input w3-border" name="pinCode" type="text"></p>
            <p>
            <p>
              <label class="w3-left"><b>Flat, House no., Building, Company, Apartment:</b></label>
              <input class="w3-input w3-border" name="addressLine1" type="text"></p>
            <p>
            <p>
              <label class="w3-left"><b>Area, Colony, Street, Sector, Village:</b></label>
              <input class="w3-input w3-border" name="addressLine2" type="text"></p>
            <p>
            <p>
              <label class="w3-left"><b>Landmark:</b></label>
              <input class="w3-input w3-border" name="landmark" type="text"></p>
            <p>
            <p>
              <label class="w3-left"><b>Town/City:</b></label>
              <input class="w3-input w3-border" name="townCity" type="text"></p>
            <p>
            <p>
              <label class="w3-left"><b>State:</b></label>
              <input class="w3-input w3-border" name="state" type="text"></p>
            <div class="w3-row w3-center w3-margin">
              <button class="w3-btn w3-white w3-border w3-round-xxlarge w3-ripple fa fa-close">Clear
              </button>
              <button class="w3-btn w3-round-xxlarge w3-red w3-hover-green w3-ripple fa fa-check">
                Submit
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</#macro>