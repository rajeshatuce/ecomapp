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
                  </#list>
                <div class="w3-display-middle w3-display-hover">
                  <button class="w3-button w3-black w3-ripple"
                          onclick="document.getElementById('productDetails').style.display='block'">
                    Buy now <i class="fa fa-shopping-cart"></i></button>
                </div>
              </div>
              <p>${col.name}<br><b>${col.currencyLabel}${col.currentUnitPrice}</b></p>
            </div>
          </div>

        </#list>
      </div>
    </#list>
  </#list>
</#macro>

