<#macro ecomapp_setting_products>
<div class="w3-container">
  <div class="w3-card-4 w3-padding ecomapp-margin-top-28px w3-margin-bottom">
    <div class="w3-container w3-brown">
      <h6>Products</h6>
    </div>
    <div class="w3-responsive w3-margin-top" data-ng-init="fetchAllProducts(1,50)">
      <input type="hidden" id="cdnIMGURL" value="${CDN_IMG_URL}"/>
      <table class="w3-table-all w3-centered">
        <thead>
        <tr class="w3-brown">
          <th>PIC</th>
          <th>NAME</th>
          <th>PRODUCT GROUP</th>
          <th>CURRENT UNIT PRICE</th>
          <th>MAX QUANTITY</th>
          <th>STATUS</th>
          <th>PREVIOUS UNIT PRICE</th>
          <th>CURRENCY LABEL</th>
          <th>STAR RATING</th>
          <th>SHORT DESCRIPTION</th>
          <th>POINTS DESCRIPTION</th>
          <th>CREATED BY</th>
          <th>CREATED DATE</th>
          <th>MODIFIED BY</th>
          <th>MODIFIED DATE</th>
          <th>ID</th>
          <th></th>
        </tr>
        </thead>
        <tr ng-repeat="p in products track by $index">
          <td><img ng-src="{{p.productThumbNailLink}}"
                   class="w3-col s3 w3-circle w3-padding-small mycartIcon"></td>
          <td>{{p.name}}</td>
          <td>{{p.productGroup}}</td>
          <td>{{p.currentUnitPrice}}</td>
          <td>{{p.maxQuantityPerOrder}}</td>
          <td>{{p.status}}</td>
          <td>{{p.previousUnitPrice}}</td>
          <td>{{p.currencyLabel}}</td>
          <td>{{p.starRating}}</td>
          <td>{{p.shortDescription}}</td>
          <td>{{p.pointsDescription}}</td>
          <td>{{p.createdBy}}</td>
          <td>{{p.createDateFormatted}}</td>
          <td>{{p.modifiedBy}}</td>
          <td>{{p.modifiedDateFormatted}}</td>
          <td>{{p.id}}</td>
          <td>
            <button
                class="w3-button w3-tiny w3-hover-green w3-pale-yellow w3-border w3-border-red w3-round-large w3-ripple fa fa-edit"
            >EDIT
            </button>
          </td>
        </tr>
      </table>
    </div>
    <!-- Pagination below-->
    <div class="w3-container ecomapp-margin-top-28px w3-margin-bottom">
      <div class="w3-row w3-center">
        <div class="w3-bar w3-border w3-round">
          <select class="w3-select" name="pageoption" ng-model="productsCurrentPageNumber"
                  ng-change="fetchAllProducts(productsCurrentPageNumber,50)">
            <option value="{{$index+1}}"
                    ng-repeat="x in [].constructor(productsTotalPages) track by $index">Page
              {{$index+1}} of {{productsTotalPages}}
            </option>
          </select>
        </div>
      </div>
    </div>
  </div>
</div>
</#macro>