app.controller('PageController', ['$scope', '$route', '$routeParams','$http','$location','$rootScope', 
                                  function($scope, $route, $routeParams,$http,$location,$rootScope) 
{
       
       init($scope, $route, $routeParams,$http,$rootScope);
       function init($scope, $route, $routeParams,$http,$rootScope) 
       {
       
       }
}
]);
app.controller('UserRegController', ['$scope', '$route', '$routeParams','$http','$location','$rootScope', 
                                  function($scope, $route, $routeParams,$http,$location,$rootScope) 
{
       
       init($scope, $route, $routeParams,$http,$rootScope);
       function init($scope, $route, $routeParams,$http,$rootScope) 
       {
       
       }
       $scope.addUsers = function()
       {
       var userInfo = {
    		                			"userName": $scope.userName,
    		                			"name": $scope.name,
    		                			"designation": $scope.designation,
    		                			"reportingManager": $scope.reportingManager
       								} ;
       $http.post("/addUsers", userInfo).
       then(function(data)
    		   {
    	            $scope.userName = "";
    	            $scope.name = "";
    	            $scope.designation = "";
    	            $scope.reportingManager = "";
    	   			console.log("Users Added");
    		   });
       }
}   
]);

