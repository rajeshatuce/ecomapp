// Creating the Admin Angular Controller
adminApp.controller('ecomappAdminCtrl', function ($http, $scope) {

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
});