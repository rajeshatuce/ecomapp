<#macro ecomapp_orders_table>
  <!-- Orders Table-->
  <div class="w3-container">
    <div class="w3-panel w3-border-bottom ecomapp-margin-top-28px">
      <h5><i class="fa fa-shopping-cart"></i>My Orders</h5>
    </div>
    <!-- Products Added in Cart Table-->
    <div class="w3-responsive w3-card-4" data-ng-init="fetchOrdersForCustomer(1,10)">
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
        <tr ng-repeat="o in customerOrders track by $index">
          <td>
            <form action="/viewOrdersForCustomer" method="get" target="_blank">

              <input name="orderId" type="hidden" value="{{o.orderId}}"/>
              <button
                  class="w3-btn w3-white w3-border w3-border-red w3-round-xlarge w3-ripple fa fa-edit"
                  type="submit">
                <b>{{o.productsOrdered.length}} Items</b></button>
            </form>
          </td>
          <td ng-if="o.deliveryStatus=='In_Progress'"><i
              class="fa fa-clock-o w3-text-orange w3-xlarge" title="In Progress"></i></td>
          <td ng-if="o.deliveryStatus=='Cancelled'"><i
              class="fa fa-times-circle w3-text-red w3-xlarge" title="Cancelled"></i></td>
          <td ng-if="o.deliveryStatus=='Done'"><i class="fa fa-check-circle w3-text-green w3-xlarge"
                                                  title="Done"></i></td>
          <td ng-if="o.paymentStatus=='In_Progress'"><i
              class="fa fa-clock-o w3-text-orange w3-xlarge" title="In Progress"></i></td>
          <td ng-if="o.paymentStatus=='Failed'"><i class="fa fa-times-circle w3-text-red w3-xlarge"
                                                   title="Failed"></i></td>
          <td ng-if="o.paymentStatus=='Refunded'"><i class="fa fa-reply w3-text-green w3-xlarge"
                                                     title="Refunded"></i></td>
          <td ng-if="o.paymentStatus=='Done'"><i class="fa fa-check-circle w3-text-green w3-xlarge"
                                                 title="Done"></i></td>
          <td ng-if="o.orderStatus=='In_Progress'"><i
              class="fa fa-hourglass-1 w3-text-green w3-xlarge" title="In Progress"></i></td>
          <td ng-if="o.orderStatus=='Cancelled'"><i class="fa fa-thumbs-down w3-text-red w3-xlarge"
                                                    title="Cancelled"></i></td>
          <td ng-if="o.orderStatus=='Done'"><i class="fa fa-thumbs-up w3-text-green w3-xlarge"
                                               title="Done"></i></td>
          <td><b>{{o.currencyLabel}} {{o.formattedTotalCharges}}</b></td>
          <td>{{o.paymentType}}</td>
          <td><b>{{o.createDateFormatted}}</b></td>
          <td>{{o.orderId}}</td>
        </tr>
        </tbody>
      </table>
    </div>
    <!-- Pagination below-->
    <div class="w3-container ecomapp-margin-top-28px w3-margin-bottom">
      <div class="w3-row w3-center">
        <div class="w3-bar w3-border w3-round">
          <select class="w3-select" name="pageoption" ng-model="customerOrdersCurrentPageNumber"
                  ng-change="fetchOrdersForCustomer(customerOrdersCurrentPageNumber,10)">
            <option value="{{$index+1}}"
                    ng-repeat="x in [].constructor(customerOrdersTotalPages) track by $index">Page
              {{$index+1}} of {{customerOrdersTotalPages}}
            </option>
          </select>
        </div>
      </div>
    </div>
  </div>

</#macro>