<#macro ecomapp_empty_cart_modal>
  <div id="emptyCartModal" class="w3-modal">
    <div class="w3-modal-content w3-animate-zoom ecomapp-modal-padding">
      <div class="w3-white w3-center">
        <i onclick="document.getElementById('emptyCartModal').style.display='none'"
           class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge ecomapp-color-white"></i>
        <div class="w3-card-4">
          <div class="w3-container w3-dark-grey">
            <h3 class="w3-left">Warning</h3>
          </div>
          <form class="w3-container" action="">
            <p>
              <label class="w3-left">
                <i class="fa fa-exclamation-triangle"></i>
                <b>Are you sure you want to empty cart?</b>
              </label>
            </p>
            <div class="w3-row w3-center w3-padding-32">
              <button class="w3-btn w3-round-xxlarge w3-red w3-hover-green fa fa-check">No
              </button>
              <button class="w3-btn w3-white w3-border w3-round-xxlarge fa fa-close">Yes
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</#macro>