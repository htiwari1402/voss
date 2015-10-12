app.controller('RequestMasterController', ['$scope', '$route', '$routeParams','$http','$location','$rootScope', 
                                  function($scope, $route, $routeParams,$http,$location,$rootScope) 
{
       init($scope, $route, $routeParams,$http,$rootScope);
       function init($scope, $route, $routeParams,$http,$rootScope) 
       {
    	   $http.post("/getAllRequests").
    	   then(function(data)
    			   {
    		            $scope.requestData = data.data;
    			   });
       }
       $scope.getRequestView = function(masterName, requestIdValue, requestID)
       {
    	   $rootScope.requestID = requestID;
    	   if (masterName == "bankmaster")
    		   {
    		       $rootScope.requestViewBank(requestIdValue);
    		   }
       }
      
}
]);