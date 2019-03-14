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

  $scope.imageSources = [];
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

  //method to open product details modal
  $scope.openProductDetailsModal = function (productId) {
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
    document.getElementById('productDetails').style.display = 'block';
  };
});