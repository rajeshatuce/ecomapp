<#macro ecomapp_top_header>
  <header class="fixed-top w3-container w3-xlarge w3-border-bottom">
    <div class="w3-col s4 w3-center"><p class="w3-left"><b>LOGO</b></p></div>
    <div class="w3-col s4 w3-center"><p><input id="search" class="ecom-search" type="text"
                                               name="search" placeholder="Search..">
      <i class="fa fa-search w3-hover-opacity"></i></p>
    </div>
    <div class="w3-col s4 w3-right">
      <div class="w3-right header-rightdiv">
        <div class="dropdown" style="display:inline;">
          <i class='fas fa-user w3-hover-opacity'></i><span class="ecomapp-hellouser"> Hello,<span
            id="shortUserName"> Rajesh</span></span>
          <div class="dropdown-content w3-hover-shadow">
            <a href="#">My Account</a>
            <a href="#">My Orders</a>
            <a href="#">Customer Service</a>
            <a href="#">Logout</a>
          </div>
        </div>

        <div class="dropdown" style="display:inline;">
          <i class="fa fa-shopping-cart w3-hover-opacity dropbtn"></i>
          <span class="w3-badge w3-small w3-right w3-black">3</span>
          <div class="dropdown-content">
            <div class="w3-row">
              <div class="w3-container mycart">
                <ul class="w3-ul w3-card-4">
                  <li class="w3-bar">
                    <span onclick="this.parentElement.style.display='none'"
                          class="w3-col s1 w3-button w3-white w3-xlarge w3-right">×</span>
                    <img src="${CDN_IMG_URL}jeans3.jpg"
                         class="w3-col s3 w3-circle w3-padding-small mycartIcon">
                    <div class="w3-col s3 w3-padding-small">
                      <span class="w3-small"><b>Style Jeans</b></span><br>
                      <span class="w3-tiny w3-text-gray">1 X 450</span>
                    </div>
                    <div class="w3-col s2 w3-padding-small">
                      <span class="w3-small">
                        <select class="w3-select" name="quantity">
                          <option value="1" selected="selected">1</option>
                          <option value="2">2</option>
                          <option value="3">3</option>
                        </select>
                      </span>
                    </div>
                    <div class="w3-col s3 w3-padding-small">
                      <span class="w3-small">Rs. 450.00</span>
                    </div>


                  </li>

                  <li class="w3-bar">
                    <span onclick="this.parentElement.style.display='none'"
                          class="w3-col s1 w3-button w3-white w3-xlarge w3-right">×</span>
                    <img src="${CDN_IMG_URL}jeans4.jpg"
                         class="w3-col s3 w3-circle w3-padding-small mycartIcon">
                    <div class="w3-col s3 w3-padding-small">
                      <span class="w3-small"><b>New Style Jeans</b></span><br>
                      <span class="w3-tiny w3-text-gray">1 X 750</span>
                    </div>
                    <div class="w3-col s2 w3-padding-small">
                      <span class="w3-small">
                        <select class="w3-select" name="quantity">
                          <option value="1" selected="selected">1</option>
                          <option value="2">2</option>
                          <option value="3">3</option>
                        </select>
                      </span>
                    </div>
                    <div class="w3-col s3 w3-padding-small">
                      <span class="w3-small">Rs. 750.00</span>
                    </div>

                  </li>

                  <li class="w3-bar">
                    <span onclick="this.parentElement.style.display='none'"
                          class="w3-col s1 w3-button w3-white w3-xlarge w3-right">×</span>
                    <img src="${CDN_IMG_URL}jeans5.jpg"
                         class="w3-col s3 w3-padding-small w3-circle mycartIcon">
                    <div class="w3-col s3 w3-padding-small">
                      <span class="w3-small"><b>Super Style Jeans</b></span><br>
                      <span class="w3-tiny w3-text-gray">1 X 950</span>
                    </div>
                    <div class="w3-col s2 w3-padding-small">
                      <span class="w3-small">
                        <select class="w3-select" name="quantity">
                          <option value="1" selected="selected">1</option>
                          <option value="2">2</option>
                          <option value="3">3</option>
                        </select>
                      </span>
                    </div>
                    <div class="w3-col s3 w3-padding-small">
                      <span class="w3-small">Rs. 950.00</span>
                    </div>

                  </li>
                  <li class="w3-bar">
                    <span onclick="this.parentElement.style.display='none'"
                          class="w3-col s1 w3-button w3-white w3-xlarge w3-right">×</span>
                    <img src="${CDN_IMG_URL}jeans2.jpg"
                         class="w3-col s3 w3-padding-small w3-circle mycartIcon">
                    <div class="w3-col s3 w3-padding-small">
                      <span class="w3-small"><b>Super Style Jeans</b></span><br>
                      <span class="w3-tiny w3-text-gray">1 X 250</span>
                    </div>
                    <div class="w3-col s2 w3-padding-small">
                      <span class="w3-small">
                        <select class="w3-select" name="quantity">
                          <option value="1" selected="selected">1</option>
                          <option value="2">2</option>
                          <option value="3">3</option>
                        </select>
                      </span>
                    </div>
                    <div class="w3-col s3 w3-padding-small">
                      <span class="w3-small">Rs. 250.00</span>
                    </div>

                  </li>
                  <li class="w3-bar">
                    <span onclick="this.parentElement.style.display='none'"
                          class="w3-col s1 w3-button w3-white w3-xlarge w3-right">×</span>
                    <img src="${CDN_IMG_URL}jeans5.jpg"
                         class="w3-col s3 w3-padding-small w3-circle mycartIcon">
                    <div class="w3-col s3 w3-padding-small">
                      <span class="w3-small"><b>Super Style Jeans</b></span><br>
                      <span class="w3-tiny w3-text-gray">1 X 950</span>
                    </div>
                    <div class="w3-col s2 w3-padding-small">
                      <span class="w3-small">
                        <select class="w3-select" name="quantity">
                          <option value="1" selected="selected">1</option>
                          <option value="2">2</option>
                          <option value="3">3</option>
                        </select>
                      </span>
                    </div>
                    <div class="w3-col s3 w3-padding-small">
                      <span class="w3-small">Rs. 950.00</span>
                    </div>

                  </li>
                </ul>
              </div>
            </div>
            <div class="w3-row w3-right">
              <button class="payment_button"><span>Rs. 2012.45</span></button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </header>
</#macro>

