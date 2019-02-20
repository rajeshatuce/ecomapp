<#macro product_details_modal>
  <div id="productDetails" class="w3-modal">
    <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
      <div class="w3-container w3-white w3-center">
        <i onclick="document.getElementById('productDetails').style.display='none'"
           class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
        <div class="w3-row">
          <div class="w3-container w3-twothird">
            <div class="w3-content w3-display-container">
              <img class="mySlides" src="${CDN_IMG_URL}jeans1.jpg" style="width:100%">
              <img class="mySlides" src="${CDN_IMG_URL}jeans2.jpg" style="width:100%">
              <img class="mySlides" src="${CDN_IMG_URL}jeans3.jpg" style="width:100%">
              <img class="mySlides" src="${CDN_IMG_URL}jeans4.jpg" style="width:100%">

              <button class="w3-button w3-black w3-display-left" onclick="plusDivs(-1)">&#10094;
              </button>
              <button class="w3-button w3-black w3-display-right" onclick="plusDivs(1)">&#10095;
              </button>
            </div>
          </div>
          <div class="w3-container w3-third w3-left-align">
            <h3>Tailored Jeans</h3>
            <p>Some text about the jeans..</p>
            <p>
            <ul class="w3-text-gray">
              <li>Best Cotton</li>
              <li>Fine Color</li>
              <li>Awsome Looks</li>
            </ul>
            </p>
            <div>
              <span class="fa fa-star checked"></span>
              <span class="fa fa-star checked"></span>
              <span class="fa fa-star checked"></span>
              <span class="fa fa-star checked"></span>
              <span class="fa fa-star"></span>
            </div>
            <hr/>
            <p>Price: <b>$19.99</b></p>
            <select class="w3-select" name="quantity">
              <option value="1" selected="selected">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
            </select>
            <p>
              <button class="w3-button w3-black w3-round-xlarge">Add to Cart</button>
            </p>
          </div>
        </div>
      </div>
    </div>
  </div>
</#macro>