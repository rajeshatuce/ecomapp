// Creating the Angular Controller
app.controller('ecomappCtrl', function ($http, $scope) {

  // method for getting user details
  var getUser = function () {
    $http.get('/user').then(function (response) {
      $scope.user = response.data;
      console.log('Logged User : ', user);
    }).catch(function (err) {
    });
  };
  getUser();

  // method for logout
  $scope.logout = function () {
    $http.post('/logout').then(function (res) {
      $scope.user = null;
    }).catch(function (err) {
    });
  };
  //method for checkout shopping cart
  $scope.checkoutShoppingCart = function () {
    window.location = "/checkout";
  };
  //************************Initialization blocks************************
  //Model for product details modal
  $scope.imageSources = [];
  $scope.productMainThumbnail = "";
  $scope.productName = "";
  $scope.shortDescription = "";
  $scope.pointsDescriptionArray = [];
  $scope.starRating = 0;
  $scope.balanceStarRating = 0;
  $scope.currencyLabel = "";
  $scope.currentUnitPrice = 0;
  $scope.maxQuantityPerOrder = 1;
  $scope.selectedQuantity = "1";
  $scope.previousUnitPrice = 0;
  $scope.productId = "";
  //Shopping cart Model
  $scope.shoppingCart = {};
  $scope.shoppingCart.products = [];
  $scope.shoppingCart.total = 0.00;
  $scope.shoppingCart.totalProductCount = 0;
  $scope.shoppingCart.currencyLabel = "";

  //Utility Method for loading shopping cart from local storage
  $scope.loadShoppingCartFromLocalStorage = function () {
    try {
      //Attempt to load shopping cart from localstorage if available
      var shoppingCartFromLocalStorage = localStorage.getItem('shoppingCart');
      if (shoppingCartFromLocalStorage != undefined
          && shoppingCartFromLocalStorage.length > 0) {
        var tmp = JSON.parse(shoppingCartFromLocalStorage);
        console.log('shoppingCartFromLocalStorage: ', tmp);
        $scope.shoppingCart = tmp;
      }
    } catch (ex) {
      console.log(
          "Exception occurred while loading shopping cart from localstorage",
          ex);
    }
  };
  $scope.loadShoppingCartFromLocalStorage();
  //Utility Method to persist shopping cart to local storage
  $scope.persistShoppingCartToLocalStorage = function () {
    try {
      localStorage.setItem('shoppingCart', JSON.stringify($scope.shoppingCart));
    } catch (ex) {
      console.log(
          "Exception occurred while persisting shopping cart to localstorage",
          ex);
    }
  };
  //**************************Event specific methods ******************************
  //method to open product details modal
  $scope.openProductDetailsModal = function (productId) {
    //create product image sources
    var results = document.getElementsByClassName(productId
        + "_productPicture");
    document.getElementById("productDetailsPicture").innerHTML = "";
    for (var i = 0; i < results.length; i++) {
      var elem = document.createElement("img");
      elem.src = results[i].value;
      elem.classList.add("mySlides");
      elem.classList.add("product-picture-modal-width");
      elem.alt = "product picture";
      document.getElementById("productDetailsPicture").appendChild(elem);
    }
    slideIndex = 1;
    showDivs(1);//make one image visible
    //Set details
    $scope.productName = document.getElementById(productId + "_name").value;
    $scope.shortDescription = document.getElementById(productId
        + "_shortDescription").value;
    var temp = document.getElementById(productId + "_pointsDescription").value;
    temp = temp.split("*");//split at star
    $scope.pointsDescriptionArray = [];
    for (i = 0; i < temp.length; i++) {
      if (temp[i].trim().length > 0) {
        $scope.pointsDescriptionArray.push(temp[i].trim());
      }
    }
    $scope.starRating = parseInt(
        document.getElementById(productId + "_starRating").value);
    $scope.balanceStarRating = 5 - $scope.starRating;
    $scope.currencyLabel = document.getElementById(productId
        + "_currencyLabel").value;
    $scope.currentUnitPrice = document.getElementById(productId
        + "_currentUnitPrice").value;
    $scope.maxQuantityPerOrder = parseInt(
        document.getElementById(productId + "_maxQuantityPerOrder").value);
    $scope.selectedQuantity = "1";
    $scope.previousUnitPrice = document.getElementById(productId
        + "_previousUnitPrice").value;
    $scope.productMainThumbnail = document.getElementById(productId
        + "_productMainThumbNail").value;
    $scope.productId = productId;
    //display product details modal
    document.getElementById('productDetails').style.display = 'block';
  };

  //method to add product to shopping cart
  $scope.addProductToShoppingCart = function () {
    //check if product already in shopping cart then ignore this addition
    for (i = 0; i < $scope.shoppingCart.products.length; i++) {
      if ($scope.shoppingCart.products[i].productId == $scope.productId) {
        console.log($scope.productId
            + ", already in shopping cart. Not doing anything");
        document.getElementById('productDetails').style.display = 'none';
        return;
      }
    }
    //add new product to shopping cart
    productToAdd = {};
    productToAdd.productId = $scope.productId;
    productToAdd.thumbNail = $scope.productMainThumbnail;
    productToAdd.productName = $scope.productName;
    productToAdd.currentUnitPrice = $scope.currentUnitPrice;
    productToAdd.maxQuantityPerOrder = $scope.maxQuantityPerOrder;
    productToAdd.selectedQuantity = $scope.selectedQuantity;
    productToAdd.subTotal = Math.round((parseFloat($scope.currentUnitPrice)
        * parseFloat($scope.selectedQuantity)) * 100) / 100;
    $scope.shoppingCart.products.push(productToAdd);
    $scope.shoppingCart.currencyLabel = $scope.currencyLabel;
    $scope.shoppingCart.total += productToAdd.subTotal;
    $scope.shoppingCart.total = Math.round($scope.shoppingCart.total * 100)
        / 100;
    $scope.shoppingCart.totalProductCount++;
    //product added now close the product details modal
    document.getElementById('productDetails').style.display = 'none';
    //persist shoppingcart in localstorage
    $scope.persistShoppingCartToLocalStorage();
  };
  //Method to be invoked when quantity in shopping cart changes
  $scope.onShoppingCartQuantityChange = function () {
    var total = 0;
    for (i = 0; i < $scope.shoppingCart.products.length; i++) {
      $scope.shoppingCart.products[i].subTotal = Math.round((parseFloat(
          $scope.shoppingCart.products[i].currentUnitPrice) * parseFloat(
          $scope.shoppingCart.products[i].selectedQuantity)) * 100) / 100;
      total += $scope.shoppingCart.products[i].subTotal;
    }
    $scope.shoppingCart.total = Math.round(total * 100) / 100;
    //persist new shopping cart to local storage
    $scope.persistShoppingCartToLocalStorage();
  };
  //Method to be invoked when a product is removed from shopping cart
  $scope.onRemoveProductFromShoppingCart = function (event, productId) {
    for (i = 0; i < $scope.shoppingCart.products.length; i++) {
      if ($scope.shoppingCart.products[i].productId == productId) {
        //update new total
        $scope.shoppingCart.total = Math.round(($scope.shoppingCart.total
            - $scope.shoppingCart.products[i].subTotal) * 100) / 100;
        $scope.shoppingCart.products.splice(i, 1);//remove product id from shopping cart
        $scope.shoppingCart.totalProductCount--;
        //delete the li element
        event.target.parentNode.parentNode.removeChild(event.target.parentNode);
        //persist shoppingcart in localstorage
        $scope.persistShoppingCartToLocalStorage();
        break;
      }
    }
  };
});