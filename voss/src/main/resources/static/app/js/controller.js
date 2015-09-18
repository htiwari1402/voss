app.controller('PageController', ['$scope', '$route', '$routeParams','$http','$location','$rootScope', 
                                  function($scope, $route, $routeParams,$http,$location,$rootScope) 
{
       
       init($scope, $route, $routeParams,$http,$rootScope);
       function init($scope, $route, $routeParams,$http,$rootScope) 
       {
       
       }
       $scope.fetchBankMaster = function()
       {
    	   $location.url("bankMaster");
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
app.controller('MasterController', ['$scope', '$route', '$routeParams','$http','$location','$rootScope', 
                                  function($scope, $route, $routeParams,$http,$location,$rootScope) 
{
       
       init($scope, $route, $routeParams,$http,$rootScope);
       function init($scope, $route, $routeParams,$http,$rootScope) 
       {
    	   $http.post("/getProducts").
           then(function(data)
        		   {
        	            $scope.productData = data.data;
        	            //console.log(JSON.stringify($scope.productData));
        		   });
       }
       
       
}
]);

app.controller('BankMasterController', ['$scope', '$route', '$routeParams','$http','$location','$rootScope', 
                                  function($scope, $route, $routeParams,$http,$location,$rootScope) 
{
       
       init($scope, $route, $routeParams,$http,$rootScope);
       function init($scope, $route, $routeParams,$http,$rootScope) 
       {
    	   $http.post("/getBankMaster").
           then(function(data)
        		   {
        	            $scope.bankData = data.data;
        	            //console.log(JSON.stringify($scope.productData));
        		   });
       }
       $scope.fetchNewBank = function()
       {
    	   $location.url("newBank");
       }
       $scope.addBank = function()
       {
       var bankDetail = {
   			"country": $scope.country,
   			"name": $scope.name,
   			"desc": $scope.desc,
   			"address": $scope.address,
   			"accNo":$scope.accNo,
   			"swift": $scope.swift,
   			"contactNo": $scope.contactNo,
   			"emailID":$scope.emailID,
   			"status": $scope.status,
   			"details" : $scope.details
				} ;
       $http.post("/addBank", bankDetail).
       then(function(data)
    		   {
    	   			console.log("Banks Added");
    		   });
       }
}
]);

