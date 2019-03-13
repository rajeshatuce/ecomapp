// Creating the Angular Controller
app.controller('ecomappCtrl', function ($http, $scope) {

  // method for getting user details
  var getUser = function () {
    $http.get('/user').success(function (user) {
      $scope.user = user;
      console.log('Logged User : ', user);
    }).error(function (error) {
      $scope.resource = error;
    });
  };
  getUser();

  // method for logout
  $scope.logout = function () {
    $http.post('/logout').success(function (res) {
      $scope.user = null;
    }).error(function (error) {
      console.log("Logout error : ", error);
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
    document.getElementById('productDetails').style.display = 'block';
  };
});