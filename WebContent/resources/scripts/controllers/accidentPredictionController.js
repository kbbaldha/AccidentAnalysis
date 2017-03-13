
myApp.controller('accidentPredictionController',  function($scope,DataService) {
  $scope.name = 'accidentPredictionController';
  	$scope.$parent.$watch('showDiv', function(value){
	
  		if(value == 2){
  			
  			$scope.getCities();
  		}
  		
  	});
  	
  	$scope.getCities = function(){
  		DataService.getCityList().then(function(response){
  			console.log(response.data);
  			$scope.cities = response.data;
  		})
  	}
});