<#macro product_details_modal>
  <div id="productDetails" class="w3-modal">
    <div class="w3-modal-content w3-animate-zoom ecomapp-modal-padding">
      <div class="w3-container w3-white w3-center">
        <i onclick="document.getElementById('productDetails').style.display='none'"
           class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
        <div class="w3-row">
          <div class="w3-twothird">
            <div class="w3-content w3-display-container">
              <span id="productDetailsPicture">
                <img class="mySlides" src="" style="width:100%"/>
              </span>

              <button class="w3-button w3-black w3-ripple w3-display-left" onclick="plusDivs(-1)">
                &#10094;
              </button>
              <button class="w3-button w3-black w3-ripple w3-display-right" onclick="plusDivs(1)">
                &#10095;
              </button>
            </div>
          </div>
          <div class="w3-container w3-third w3-left-align">
            <h5 class="ecomapp-fontbold">{{productName}}</h5>
            <p class="w3-small">{{shortDescription}}</p>
            <p>
            <ul class="w3-text-gray w3-small">
              <li ng-repeat="x in pointsDescriptionArray">
                {{x}}
              </li>
            </ul>
            </p>
            <div>
              <span class="fa fa-star checked"
                    ng-repeat="x in [].constructor(starRating) track by $index"></span>
              <span class="fa fa-star"
                    ng-repeat="x in [].constructor(balanceStarRating) track by $index"></span>
            </div>
            <hr/>
            <p>Price: <b>{{currencyLabel}}{{currentUnitPrice}}</b><span
                class="w3-small ecomapp-padding-left w3-text-gray"><s>{{currencyLabel}}{{previousUnitPrice}} </s></span>
            </p>
            <select class="w3-select" name="selectedQuantity" ng-model="selectedQuantity">
              <option ng-repeat="x in [].constructor(maxQuantityPerOrder) track by $index"
                      value="{{$index+1}}">{{$index+1}}
              </option>
            </select>
            <p>
              <button
                  class="w3-btn w3-round-xxlarge w3-red w3-hover-green w3-ripple fa fa-thumbs-up">
                Add to
                Cart
              </button>
            </p>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script src="${CDN_JS_URL}ecomapp_image_slideshow.js"></script>
</#macro>