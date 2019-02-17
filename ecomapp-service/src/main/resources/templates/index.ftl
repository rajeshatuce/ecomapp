<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${CDN_CSS_URL}ecomapp.css">
<body>

<!-- !PAGE CONTENT! -->
<div class="w3-main">
  <!-- Top header -->
  <header class="fixed-top w3-container w3-xlarge">
    <div class="w3-col s4 w3-center"><p class="w3-left"><b>LOGO</b></p></div>
    <div class="w3-col s4 w3-center"><p><input id="search" class="ecom-search" type="text"
                                               name="search" placeholder="Search..">
      <i class="fa fa-search"></i></p>
    </div>
    <div class="w3-col s4 w3-right">
    <p class="w3-right">
      <i class='fas fa-user'></i><span class="ecomapp-hellouser"> Hello,<span id="shortUserName"> Rajesh</span></span>
      <i class="fa fa-shopping-cart"></i>
      <span class="w3-badge w3-small w3-right w3-black">3</span>
    </p>
    </div>
  </header>

  <!-- Image header -->
  <div class="w3-display-container w3-container">
    <img src="${CDN_IMG_URL}jeans.jpg" alt="Jeans" style="width:100%">
    <div class="w3-display-topleft w3-text-white" style="padding:24px 48px">
      <h1 class="w3-jumbo w3-hide-small">New Arrivals</h1>
      <h1 class="w3-hide-large w3-hide-medium">New Arrivals</h1>
      <h1 class="w3-hide-small">COLLECTION 2019</h1>
      <p><a href="#products" class="w3-button w3-black w3-padding-large w3-large shopNowBtn">SHOP
        NOW</a></p>
    </div>
  </div>
  <!-- Product section -->
  <div class="w3-container w3-text-grey" id="products">
    <p id="productGroup">Jeans</p>
  </div>

  <!-- Product grid -->
  <div class="w3-row w3-grayscale">
    <div class="w3-col l3 s6">
      <div class="w3-container">
        <div class="w3-display-container">
          <img src="${CDN_IMG_URL}jeans1.jpg" class="products-width">
          <div class="w3-display-middle w3-display-hover">
            <button class="w3-button w3-black"
                    onclick="document.getElementById('productDetails').style.display='block'">Buy
              now <i class="fa fa-shopping-cart"></i></button>
          </div>
        </div>
        <p>Ripped Skinny Jeans<br><b>$24.99</b></p>
      </div>
      <div class="w3-container">
        <div class="w3-display-container">
          <img src="${CDN_IMG_URL}jeans3.jpg" class="products-width">
          <div class="w3-display-middle w3-display-hover">
            <button class="w3-button w3-black">Buy now <i class="fa fa-shopping-cart"></i></button>
          </div>
        </div>
        <p>Mega Ripped Jeans<br><b>$19.99</b></p>
      </div>
    </div>

    <div class="w3-col l3 s6">
      <div class="w3-container">
        <div class="w3-display-container">
          <img src="${CDN_IMG_URL}jeans2.jpg" class="products-width">
          <span class="w3-tag w3-display-topleft">New</span>
          <div class="w3-display-middle w3-display-hover">
            <button class="w3-button w3-black">Buy now <i class="fa fa-shopping-cart"></i></button>
          </div>
        </div>
        <p>Mega Ripped Jeans<br><b>$19.99</b></p>
      </div>
      <div class="w3-container">
        <div class="w3-display-container">
          <img src="${CDN_IMG_URL}jeans3.jpg" class="products-width">
          <div class="w3-display-middle w3-display-hover">
            <button class="w3-button w3-black">Buy now <i class="fa fa-shopping-cart"></i></button>
          </div>
        </div>
        <p>Washed Skinny Jeans<br><b>$20.50</b></p>
      </div>
    </div>

    <div class="w3-col l3 s6">
      <div class="w3-container">
        <div class="w3-display-container">
          <img src="${CDN_IMG_URL}jeans4.jpg" class="products-width">
          <div class="w3-display-middle w3-display-hover">
            <button class="w3-button w3-black">Buy now <i class="fa fa-shopping-cart"></i></button>
          </div>
        </div>
        <p>Washed Skinny Jeans<br><b>$20.50</b></p>
      </div>
      <div class="w3-container">
        <div class="w3-display-container">
          <img src="${CDN_IMG_URL}jeans5.jpg" class="products-width">
          <div class="w3-display-middle w3-display-hover">
            <button class="w3-button w3-black">Buy now <i class="fa fa-shopping-cart"></i></button>
          </div>
        </div>
        <p>Vintage Skinny Jeans<br><b>$14.99</b></p>
      </div>
    </div>

    <div class="w3-col l3 s6">
      <div class="w3-container">
        <div class="w3-display-container">
          <img src="${CDN_IMG_URL}jeans1.jpg" class="products-width">
          <div class="w3-display-middle w3-display-hover">
            <button class="w3-button w3-black">Buy now <i class="fa fa-shopping-cart"></i></button>
          </div>
        </div>
        <p>Vintage Skinny Jeans<br><b>$14.99</b></p>
      </div>
      <div class="w3-container">
        <div class="w3-display-container">
          <img src="${CDN_IMG_URL}jeans2.jpg" class="products-width">
          <div class="w3-display-middle w3-display-hover">
            <button class="w3-button w3-black">Buy now <i class="fa fa-shopping-cart"></i></button>
          </div>
        </div>
        <p>Ripped Skinny Jeans<br><b>$24.99</b></p>
      </div>
    </div>
  </div>

  <!-- Subscribe section -->
  <div class="w3-container w3-black w3-padding-32">
    <h1>Subscribe</h1>
    <p>To get special offers and VIP treatment:</p>
    <p><input class="w3-input w3-border" type="text" placeholder="Enter e-mail" style="width:100%">
    </p>
    <button type="button" class="w3-button w3-red w3-margin-bottom">Subscribe</button>
  </div>

  <!-- Footer -->
  <footer class="w3-padding-64 w3-light-grey w3-small w3-center" id="footer">
    <div class="w3-row-padding">
      <div class="w3-col s4">
        <h4>Contact</h4>
        <p>Questions? Go ahead.</p>
        <form action="/action_page.php" target="_blank">
          <p><input class="w3-input w3-border" type="text" placeholder="Name" name="Name" required>
          </p>
          <p><input class="w3-input w3-border" type="text" placeholder="Email" name="Email"
                    required></p>
          <p><input class="w3-input w3-border" type="text" placeholder="Subject" name="Subject"
                    required></p>
          <p><input class="w3-input w3-border" type="text" placeholder="Message" name="Message"
                    required></p>
          <button type="submit" class="w3-button w3-block w3-black">Send</button>
        </form>
      </div>

      <div class="w3-col s4">
        <h4>About</h4>
        <p><a href="#">About us</a></p>
        <p><a href="#">We're hiring</a></p>
        <p><a href="#">Support</a></p>
        <p><a href="#">Find store</a></p>
        <p><a href="#">Shipment</a></p>
        <p><a href="#">Payment</a></p>
        <p><a href="#">Gift card</a></p>
        <p><a href="#">Return</a></p>
        <p><a href="#">Help</a></p>
      </div>

      <div class="w3-col s4 w3-justify">
        <h4>Store</h4>
        <p><i class="fa fa-fw fa-map-marker"></i> Company Name</p>
        <p><i class="fa fa-fw fa-phone"></i> 0044123123</p>
        <p><i class="fa fa-fw fa-envelope"></i> ex@mail.com</p>
        <h4>We accept</h4>
        <p><i class="fa fa-fw fa-cc-amex"></i> Amex</p>
        <p><i class="fa fa-fw fa-credit-card"></i> Credit Card</p>
        <br>
        <i class="fa fa-facebook-official w3-hover-opacity w3-large"></i>
        <i class="fa fa-instagram w3-hover-opacity w3-large"></i>
        <i class="fa fa-snapchat w3-hover-opacity w3-large"></i>
        <i class="fa fa-pinterest-p w3-hover-opacity w3-large"></i>
        <i class="fa fa-twitter w3-hover-opacity w3-large"></i>
        <i class="fa fa-linkedin w3-hover-opacity w3-large"></i>
      </div>
    </div>
  </footer>

  <div class="w3-black w3-center w3-padding-24">&copy;2019
    <a
        href="" title="LOGO" target="_blank"
        class="w3-hover-opacity">LOGO</a>
    . All rights reserved.
  </div>

  <!-- End page content -->
</div>

<!-- Product Details Modal -->
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

<script src="${CDN_JS_URL}ecomapp.js"></script>

</body>
</html>
