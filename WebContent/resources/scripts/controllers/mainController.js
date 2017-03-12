
myApp.controller('mainController',  function($scope) {
  $scope.name = 'mainController';
  
  
  $scope.show = function(showValue){
	  $scope.showDiv = showValue;
  }
});