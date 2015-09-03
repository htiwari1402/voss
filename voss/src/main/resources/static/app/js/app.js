var app = angular.module('voss', ['ui.bootstrap', 'dialogs.main','pascalprecht.translate','dialogs.default-translations','ngRoute', 'uiSlider','ngSanitize','xeditable','ng.shims.placeholder','angularSpinner']);

app.config(['$routeProvider', function($routeProvider) {
	  $routeProvider.when('/welcome', {
	    controller : 'PageController',
	    templateUrl : './app/partials/productMaster.html'
	  })
	  .otherwise({
	    redirectTo : '/'
	  });
	}]);
