<#macro ecomapp_product_section>
  <#list ACTIVE_PRODUCTS as key,value>

    <div class="w3-container w3-text-grey" id="products">
      <h5 id="productGroup">${key}</h5>
    </div>

  <!-- Product grid -->
    <#list value?chunk(4) as row>
      <div class="w3-row">
        <#list row as col>
          <div class="w3-quarter">
            <div class="w3-container">
              <div class="w3-display-container">
                  <#list col.productPictures as picture>
                    <#if picture.productThumbNail>
                      <img src="${CDN_IMG_URL}${picture.uniqueFileName}" class="products-width">
                      <#if col.textOnImage?has_content>
                        <span class="w3-tag w3-display-topleft">${col.textOnImage}</span>
                      </#if>
                    </#if>
                    <input class="${col.id}_productPicture" type="hidden"
                           value="${CDN_IMG_URL}${picture.uniqueFileName}"/>
                  </#list>
                <div class="w3-display-middle w3-display-hover">
                  <button class="w3-button w3-black w3-ripple"
                          ng-click="openProductDetailsModal('${col.id}')">
                    Buy now <i class="fa fa-shopping-cart"></i></button>
                </div>
              </div>
              <input id="${col.id}_currentUnitPrice" type="hidden" value="${col.currentUnitPrice}"/>
              <input id="${col.id}_shortDescription" type="hidden" value="${col.shortDescription}"/>
              <input id="${col.id}_name" type="hidden" value="${col.name}"/>
              <input id="${col.id}_pointsDescription" type="hidden"
                     value="${col.pointsDescription}"/>
              <input id="${col.id}_starRating" type="hidden" value="${col.starRating}"/>
              <input id="${col.id}_previousUnitPrice" type="hidden"
                     value="${col.previousUnitPrice}"/>
              <input id="${col.id}_maxQuantityPerOrder" type="hidden"
                     value="${col.maxQuantityPerOrder}"/>
              <input id="${col.id}_productGroup" type="hidden" value="${col.productGroup}"/>
              <input id="${col.id}_currencyLabel" type="hidden" value="${col.currencyLabel}"/>
              <p>${col.name}<br><b>${col.currencyLabel}${col.currentUnitPrice}</b><span
                  class="w3-small ecomapp-padding-left w3-text-gray"><s>${col.currencyLabel}${col.previousUnitPrice} </s></span>
              </p>
            </div>
          </div>

        </#list>
      </div>
    </#list>
  </#list>
</#macro>

