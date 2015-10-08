app.controller('loginController', ['$scope', '$route', '$routeParams','$http','$location','$rootScope', 
                                  function($scope, $route, $routeParams,$http,$location,$rootScope) 
{
       
       init($scope, $route, $routeParams,$http,$rootScope);
       function init($scope, $route, $routeParams,$http,$rootScope) 
       {
    	   $scope.isAuthenticated  = 0;
       }
       $scope.login = function()
       {
    	   var loginDetail = {
    			   "username" : $scope.username,
    			   "password" : $scope.password
    	   };
    	   $http.post("/authenticate", loginDetail).
    	   then(function(data)
    			   {
    		          $scope.isAuthenticated = data.data;
    		          if($scope.isAuthenticated == 1)
    	    		   {
    	    		     //$location.url("home");
    	    		     window.location.href = "home";
    	    		     //console.log("authenticated");
    	    		   }
    		          console.log($scope.isAuthenticated);
    			   });
    	   
    	   
    	   //console.log("username "+$scope.username+ " password: "+ $scope.password);
       }
}
]);