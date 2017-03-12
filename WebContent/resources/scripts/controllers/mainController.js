
myApp.controller('mainController',  function($scope, DataService) {
  $scope.name = 'mainController';
  
  
  $scope.show = function(showValue){
	  $scope.showDiv = showValue;
	  DataService.getCountryList().then(function(response){
		  console.log(response.data);
	  });
  }
});