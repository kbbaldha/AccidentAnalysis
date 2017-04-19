
myApp.controller('mainController',  function($scope, DataService) {
  $scope.name = 'mainController';
  
  $scope.loader = {};
  $scope.loader.loading = false;
  
  $scope.show = function(showValue){
	  $scope.$broadcast('initEvent',showValue);
	  
	  $scope.showDiv = showValue;
	  console.log(showValue);
	  
	 
	  //DataService.getCountryList().then(function(response){
		//  console.log(response.data);
	  //});
  }
  
  $scope.show(8);
  
  $scope.$watch("loading",function(){
	  console.log('changed');
  })
});


myApp.controller('tableDataController',  function($scope, DataService) {
	$scope.$parent.$watch('showDiv', function(value){
			
			if(value == 7){
				
				$scope.getTableData();
			}
			
		});
	
	$scope.getTableData = function(){
		$scope.$parent.loader.loading = true;
		DataService.getTableData().then(function(response){
			//console.log(response.data);
			$scope.tables = response.data;
			$scope.total = $scope.tables[$scope.tables.length - 1];
			$scope.$parent.loader.loading = false;
		});
	}
});
