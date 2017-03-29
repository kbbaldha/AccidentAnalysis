
myApp.controller('accidentPredictionController',  function($scope,DataService) {
  $scope.name = 'accidentPredictionController';
  	$scope.$parent.$watch('showDiv', function(value){
	
  		if(value == 2){
  			
  			$scope.getCities();
  		}
  		
  	});
  	
  	
  	
  	$scope.getCities = function(){
  		//console.log($scope.$parent.loader.loading);
  		$scope.$parent.loader.loading = true;
  		DataService.getCityList().then(function(response){
  			//console.log($scope.$parent.loader.loading);
  			$scope.$parent.loader.loading = false;
  			$scope.cities = response.data;
  			
  		},function(error){
  			$scope.$parent.loader.loading = false;
  		})
  	}
});