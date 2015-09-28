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
	  .when('/businessUnit', {
	    controller : 'PageController',
	    templateUrl : './app/partials/business-unit.html'
	  })
	  .otherwise({
        redirectTo: '/'
      });
	}]);

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
       $scope.fetchBusinessUnit = function()
       {
    	   $location.url("businessUnit");
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


app.controller('BankMasterController', ['$scope', '$route', '$routeParams','$http','$location','$rootScope', 
                                  function($scope, $route, $routeParams,$http,$location,$rootScope) 
{
       
       init($scope, $route, $routeParams,$http,$rootScope);
       function init($scope, $route, $routeParams,$http,$rootScope) 
       {
    	   $scope.currentPage = 1;
    	   $http.post("/getBankMasterSize").
           then(function(data)
        		   {
        	            $scope.bankDataSize = data.data;
        	            //console.log(JSON.stringify($scope.productData));
        	            if($scope.bankDataSize%10 == 0)
        	            	{
        	            	    $scope.noOfPages = $scope.bankDataSize/10;
        	            	}
        	            else
        	            	{
        	            	   $scope.noOfPages = (($scope.bankDataSize - $scope.bankDataSize%10)/10) + 1;
        	            	}
        	            $scope.getNumber = function(num) {
        	                return new Array(num);   
        	            }
        	            console.log($scope.noOfPages);
        		   });
    	   $http.post("/getBankMaster").
           then(function(data)
        		   {
        	            $scope.bankData = data.data;
        	            //console.log(JSON.stringify($scope.productData));
        		   });
    	   $scope.reload = function(pageNo)
    	   {
    		   $http.get("/getBankMaster?page="+pageNo).
               then(function(data)
            		   {
            	            $scope.bankData = data.data;
            	            //console.log(JSON.stringify($scope.productData));
            		   });
    		   $scope.currentPage = pageNo;
    	   }
    	   $scope.next = function()
    	   {
    		   $http.get("/getBankMaster?page="+($scope.currentPage+1)).
               then(function(data)
            		   {
            	            $scope.bankData = data.data;
            	            //console.log(JSON.stringify($scope.productData));
            		   });
    		   $scope.currentPage = $scope.currentPage+1;
    	   }
    	   $scope.last = function()
    	   {
    		   $http.get("/getBankMaster?page="+($scope.currentPage-1)).
               then(function(data)
            		   {
            	            $scope.bankData = data.data;
            	            //console.log(JSON.stringify($scope.productData));
            		   });
    		   $scope.currentPage = $scope.currentPage-1;
    	   }
    	   $rootScope.selectedBank = 0;
       }
       $scope.fetchNewBank = function()
       {
    	   $location.url("newBank");
       }
       $scope.selectBank=function(bankID)
       {
    	   
    	   if($rootScope.selectedBank > 0)
    		   {
    		   		$rootScope.selectedBank = 0;
    		   		/*$scope.selectedRow = {
    		    			   backgroundColor: "white"
    		    	   };*/
    		   		console.log("deselect");
    		   		angular.element($('.select'+bankID)).css("background-color","white");
    		   }
    	   else
    		   {
    		   $rootScope.selectedBank = bankID;
        	   /*$scope.selectedRow = {
        			   backgroundColor: "blue"
        	   };*/
        	   console.log("select");
        	   angular.element($('.select'+bankID)).css("background-color","green");
    		   }
       }
       $scope.editBank = function()
       {
    	   $location.url("editBank");
    	   
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
app.controller('EditBankController', ['$scope', '$route', '$routeParams','$http','$location','$rootScope', 
                                    function($scope, $route, $routeParams,$http,$location,$rootScope) 
  {
         
         init($scope, $route, $routeParams,$http,$rootScope);
         function init($scope, $route, $routeParams,$http,$rootScope) 
         {
        	 $http.get("/getBankByID?bankID="+ $scope.selectedBank).
             then(function(data)
          		   {
          	            JSON.stringify(data);
          	             $scope.country = data.data.country;
        			         $scope.name = data.data.name;
        			         $scope.desc = data.data.desc;
        			         $scope.address = data.data.address;
        			         $scope.accNo = data.data.accNo;
        			         $scope.swift = data.data.swift;
        			         $scope.contactNo = data.data.contactNo;
        			         $scope.emailID = data.data.emailID;
        			         $scope.status = data.data.status;
        			         $scope.details= data.data.details;
          		   });
         }
         $scope.editBank = function()
         {
         var bankDetail = {
        		 "bankID": $rootScope.selectedBank,
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
         $http.post("/editBank", bankDetail).
         then(function(data)
      		   {
        	         $location.url("bankMaster");
      		   });
         }
         
         
  }
  ]);
