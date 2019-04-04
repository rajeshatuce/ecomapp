// Creating angular Application with module name "ecomappAdmin"
var adminApp = angular.module('ecomappAdmin', []);

adminApp.config(['$httpProvider', function ($httpProvider) {
  $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
}]);