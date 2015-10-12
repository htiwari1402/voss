var app = angular.module('voss', ['ui.bootstrap', 'dialogs.main','pascalprecht.translate','dialogs.default-translations','ngRoute', 'uiSlider','ngSanitize','xeditable','ng.shims.placeholder','angularSpinner']);

app.config(['$routeProvider', function($routeProvider) {
	  $routeProvider
	  .when('/bankMaster', {
	    controller : 'PageController',
	    templateUrl : './app/partials/bankMaster.html'
	  })
	  .when('/newBank', {
	    controller : 'PageController',
	    templateUrl : './app/partials/newBank.html'
	  })
	  .when('/editBank', {
	    controller : 'PageController',
	    templateUrl : './app/partials/editBank.html'
	  })
	  .when('/viewBank', {
	    controller : 'PageController',
	    templateUrl : './app/partials/viewBank.html'
	  })
	  .when('/businessUnit', {
	    controller : 'PageController',
	    templateUrl : './app/partials/business-unit.html'
	  })
	  .when('/requestMaster', {
	    controller : 'PageController',
	    templateUrl : './app/partials/requestMaster.html'
	  })
	  .otherwise({
        redirectTo: '/'
      });
	}]);
