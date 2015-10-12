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
app.controller('PageController', ['$scope', '$route', '$routeParams','$http','$location','$rootScope', 
                                  function($scope, $route, $routeParams,$http,$location,$rootScope) 
{
       
       init($scope, $route, $routeParams,$http,$rootScope);
       function init($scope, $route, $routeParams,$http,$rootScope) 
       {
    	   $rootScope.pendingStatus = 'Disable';
    	   $http.get("/getUserDetail").
           then(function(data)
        		   {
        	               $rootScope.userDetail = data.data;
        		   });
       }
       $scope.fetchBankMaster = function()
       {
    	   $location.url("bankMaster");
       }
       $scope.fetchBusinessUnit = function()
       {
    	   $location.url("businessUnit");
       }
       $scope.fetchRequestMaster = function()
       {
    	   $location.url("requestMaster");
       }
       $rootScope.requestViewBank = function(id)
       {
    	   $location.url("viewBank");
    	   $http.get("/getBankByID?bankID="+ id).
           then(function(data)
        		   {
        	            JSON.stringify(data);
        	             $rootScope.country = data.data.country;
      			         $rootScope.name = data.data.name;
      			         $rootScope.desc = data.data.desc;
      			         $rootScope.address = data.data.address;
      			         $rootScope.accNo = data.data.accNo;
      			         $rootScope.swift = data.data.swift;
      			         $rootScope.contactNo = data.data.contactNo;
      			         $rootScope.emailID = data.data.emailID;
      			         $rootScope.status = data.data.status;
      			         $rootScope.details= data.data.details;
        		   });
       }
       $rootScope.backToRequestMaster = function()
       {
    	   $rootScope.requestID = null;
    	   $location.url("requestMaster");
       }
       $rootScope.approveStatus =function()
       {
    	   $http.get("/approveRequest?requestID="+ $rootScope.requestID).
           then(function(data)
        		   {
        	               alert("Request Approved !!! Status Updated !!!");
        		   });
       }
       $rootScope.rejectStatus = function()
       {
    	   $http.get("/rejectRequest?requestID="+ $rootScope.requestID).
           then(function(data)
        		   {
        	               alert("Request Rejected !!! Status Updated !!!");
        		   });
       }
       
}
]);
app.controller('UserRegController', ['$scope', '$route', '$routeParams','$http','$location','$rootScope', 
                                  function($scope, $route, $routeParams,$http,$location,$rootScope) 
{
       
       init($scope, $route, $routeParams,$http,$rootScope);
       function init($scope, $route, $routeParams,$http,$rootScope) 
       {
    	   $http.post("/getDesign").
    	   then(function(data)
    			   {
    		            $scope.des = data.data;
    			   });
    	   $http.post("/getUser").
    	   then(function(data)
    			   {
    		            $scope.userData = data.data;
    			   });
    	   
       }
       $scope.addUsers = function()
       {
       var userInfo = {
    		                			"userName": $scope.userName,
    		                			"name": $scope.name,
    		                			"designation": $scope.designation,
    		                			"reportingManager": $scope.reportingManager,
    		                			"password" :  $scope.password
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
   			"status": $rootScope.pendingStatus,
   			"details" : $scope.details
				} ;
       $http.post("/addBank", bankDetail).
       then(function(data)
    		   {
    	   			$scope.newBankID = data.data;
    	   			var requestDetail = {
    	   	    		   "userId" : $rootScope.userDetail.reportingManager,
    	   	    		   "requestingUserId" : $rootScope.userDetail.userId,
    	   	    		   "requesttable" : "bankmaster",
    	   	    		   "requestIdName" : "pk_bankID",
    	   	    		   "activationFlag" : "1",
    	   	    		   "requestTableStatusName" : "status",
    	   	    		   "updatedRequestValue" : "Enable",
    	   	    		   "requestMasterName" : "bankmaster",
    	   	    		   "date" : "2015-10-11",
    	   	    		   "requestIdValue": $scope.newBankID
    	   	       };
    	   	       $http.post("/createRequest", requestDetail).
    	   	       then(function(data)
    	   	    		   {
    	   	    	   			console.log('request created');
    	   	    		   });
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
     			"status": $rootScope.pendingStatus,
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