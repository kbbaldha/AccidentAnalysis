
myApp.controller('mainController',  function($scope, DataService) {
  $scope.name = 'mainController';
  
  $scope.loader = {};
  $scope.loader.loading = false;
  
  $scope.show = function(showValue){
	  $scope.showDiv = showValue;
	  DataService.getCountryList().then(function(response){
		  console.log(response.data);
	  });
  }
  
  $scope.$watch("loading",function(){
	  console.log('changed');
  })
});