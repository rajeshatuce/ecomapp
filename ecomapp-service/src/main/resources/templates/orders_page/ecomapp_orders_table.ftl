<#macro ecomapp_orders_table>
  <!-- Orders Table-->
  <div class="w3-container">
    <div class="w3-panel w3-border-bottom ecomapp-margin-top-28px">
      <h5><i class="fa fa-shopping-cart"></i>My Orders</h5>
    </div>
    <!-- Products Added in Cart Table-->
    <div class="w3-responsive w3-card-4">
      <table class="w3-table-all w3-small">
        <thead>
        <tr class="w3-dark-grey">
          <th>TOTAL ITEMS</th>
          <th>DELIVERY STATUS</th>
          <th>PAYMENT STATUS</th>
          <th>ORDER STATUS</th>
          <th>ORDER AMOUNT</th>
          <th>PAYMENT MODE</th>
          <th>ORDER DATE</th>
          <th>ORDER ID</th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <td>
            <button
                class="w3-btn w3-white w3-border w3-border-red w3-round-xlarge w3-ripple fa fa-edit ">
              <b>9 Items</b></button>
          </td>
          <td><i class="fa fa-clock-o w3-text-orange w3-xlarge" title="In Progress"></i></td>
          <td><i class="fa fa-times-circle w3-text-red w3-xlarge" title="Failed"></i></td>
          <td><i class="fa fa-hourglass-1 w3-text-green w3-xlarge" title="In Progress"></i></td>
          <td><b>Rs. 700.00</b></td>
          <td>Payment Gateway</td>
          <td><b>Tue 08th Feb 2019, 10:30 pm</b></td>
          <td>3DB_123_1234125</td>
        </tr>
        <tr>
          <td>
            <button
                class="w3-btn w3-white w3-border w3-border-red w3-round-xlarge w3-ripple fa fa-edit ">
              <b>8 Items</b></button>
          </td>
          <td><i class="fa fa-times-circle w3-text-red w3-xlarge" title="Cancelled"></i></td>
          <td><i class="fa fa-reply w3-text-green w3-xlarge" title="Refunded"></i></td>
          <td><i class="fa fa-thumbs-down w3-text-red w3-xlarge" title="Cancelled"></i></td>
          <td><b>Rs. 700.00</b></td>
          <td>Payment Gateway</td>
          <td><b>Tue 08th Feb 2019, 10:30 pm</b></td>
          <td>3DB_123_1234125</td>
        </tr>
        <tr>
          <td>
            <button
                class="w3-btn w3-white w3-border w3-border-red w3-round-xlarge w3-ripple fa fa-edit">
              <b>2 Items</b></button>
          </td>
          <td><i class="fa fa-clock-o w3-text-orange w3-xlarge" title="In Progress"></i></td>
          <td><i class="fa fa-check-circle w3-text-green w3-xlarge" title="Done"></i></td>
          <td><i class="fa fa-hourglass-1 w3-text-green w3-xlarge" title="In Progress"></i></td>
          <td><b>Rs. 700.00</b></td>
          <td>Payment Gateway</td>
          <td><b>Tue 08th Feb 2019, 10:30 pm</b></td>
          <td>3DB_123_1234125</td>
        </tr>
        <tr>
          <td>
            <button
                class="w3-btn w3-white w3-border w3-border-red w3-round-xlarge w3-ripple fa fa-edit">
              <b>4 Items</b></button>
          </td>
          <td><i class="fa fa-check-circle w3-text-green w3-xlarge" title="Done"></i></td>
          <td><i class="fa fa-check-circle w3-text-green w3-xlarge" title="Done"></i></td>
          <td><i class="fa fa-thumbs-up w3-text-green w3-xlarge" title="Done"></i></td>
          <td><b>Rs. 800.00</b></td>
          <td>Cash On Delivery</td>
          <td><b>Sun 04th Feb 2019, 10:33 am</b></td>
          <td>3DB_123_1232343</td>
        </tr>

        </tbody>
      </table>
    </div>
    <!-- Pagination below-->
    <div class="w3-container ecomapp-margin-top-28px w3-margin-bottom">
      <div class="w3-row w3-center">
        <div class="w3-bar w3-border w3-round">
          <a href="#" class="w3-bar-item w3-button w3-ripple">&laquo;</a>
          <a href="#" class="w3-bar-item w3-button w3-ripple w3-black">1</a>
          <a href="#" class="w3-bar-item w3-button w3-ripple">2</a>
          <a href="#" class="w3-bar-item w3-button w3-ripple">3</a>
          <a href="#" class="w3-bar-item w3-button w3-ripple">4</a>
          <a href="#" class="w3-bar-item w3-button w3-ripple">&raquo;</a>
        </div>
      </div>
    </div>
  </div>

</#macro>