// Creating angular Application with module name "ecomapp"
var app = angular.module('ecomapp', []);

app.config(['$httpProvider', function ($httpProvider) {
  $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
}]);