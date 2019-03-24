<#macro ecomapp_notification_modal>
  <div id="notificationModal" class="w3-modal">
    <div class="w3-modal-content w3-animate-zoom ecomapp-modal-padding">
      <div class="w3-white w3-center">
        <i onclick="document.getElementById('notificationModal').style.display='none'"
           class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge ecomapp-color-white"></i>
        <div class="w3-card-4">
          <div class="w3-container w3-dark-grey">
            <h3 class="w3-left">Warning</h3>
          </div>
          <div class="w3-container">
            <p>
              <label class="w3-left">
                <i class="fa fa-exclamation-triangle"></i>
                <b>{{notificationMessage}}</b>
              </label>
            </p>
            <div class="w3-row w3-center w3-padding-32">
              <button class="w3-btn w3-round-xxlarge w3-red w3-hover-green w3-ripple fa fa-check"
                      onclick="document.getElementById('notificationModal').style.display='none'">Ok
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</#macro>