app.controller('BUMasterController', ['$scope', '$route', '$routeParams','$http','$location','$rootScope', 
                                  function($scope, $route, $routeParams,$http,$location,$rootScope) 
{
       
       init($scope, $route, $routeParams,$http,$rootScope);
       function init($scope, $route, $routeParams,$http,$rootScope) 
       {
    	   $scope.currentPage = 1;
    	   $http.post("/getBUMasterSize").
           then(function(data)
        		   {
        	            $scope.buDataSize = data.data;
        	            //console.log(JSON.stringify($scope.productData));
        	            if($scope.buDataSize%10 == 0)
        	            	{
        	            	    $scope.noOfPages = $scope.buDataSize/10;
        	            	}
        	            else
        	            	{
        	            	   $scope.noOfPages = (($scope.buDataSize - $scope.buDataSize%10)/10) + 1;
        	            	}
        	            $scope.getNumber = function(num) {
        	                return new Array(num);   
        	            }
        	            console.log($scope.noOfPages);
        		   });
    	   $http.post("/getBUMaster").
           then(function(data)
        		   {
        	            $scope.buData = data.data;
        	            //console.log(JSON.stringify($scope.productData));
        		   });
    	   $scope.reload = function(pageNo)
    	   {
    		   $http.get("/getBUMaster?page="+pageNo).
               then(function(data)
            		   {
            	            $scope.buData = data.data;
            	            //console.log(JSON.stringify($scope.productData));
            		   });
    		   $scope.currentPage = pageNo;
    	   }
    	   $scope.next = function()
    	   {
    		   $http.get("/getBUMaster?page="+($scope.currentPage+1)).
               then(function(data)
            		   {
            	            $scope.buData = data.data;
            	            //console.log(JSON.stringify($scope.productData));
            		   });
    		   $scope.currentPage = $scope.currentPage+1;
    	   }
    	   $scope.last = function()
    	   {
    		   $http.get("/getBUMaster?page="+($scope.currentPage-1)).
               then(function(data)
            		   {
            	            $scope.buData = data.data;
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
       $scope.selectBU=function(buID)
       {
    	   
    	   if($rootScope.selectedBU > 0)
    		   {
    		   		$rootScope.selectedBU = 0;
    		   		/*$scope.selectedRow = {
    		    			   backgroundColor: "white"
    		    	   };*/
    		   		console.log("deselect");
    		   		angular.element($('.select'+buID)).css("background-color","white");
    		   }
    	   else
    		   {
    		   $rootScope.selectedBU = buID;
        	   /*$scope.selectedRow = {
        			   backgroundColor: "blue"
        	   };*/
        	   console.log("select");
        	   angular.element($('.select'+buID)).css("background-color","green");
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