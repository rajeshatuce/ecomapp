// Creating angular Application with module name "ecomappAdmin"
var adminApp = angular.module('ecomappAdmin', []);

adminApp.config(['$httpProvider', function ($httpProvider) {
  $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
}]);

// DIRECTIVE - FILE MODEL
adminApp.directive('fileModel', ['$parse', function ($parse) {
  return {
    restrict: 'A',
    link: function (scope, element, attrs) {
      var model = $parse(attrs.fileModel);
      var modelSetter = model.assign;

      element.bind('change', function () {
        scope.$apply(function () {
          modelSetter(scope, element[0].files[0]);
        });
      });
    }
  };

}]);