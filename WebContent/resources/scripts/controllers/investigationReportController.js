
myApp.controller('investigationReportController',  function($scope,DataService) {
  $scope.name = 'investigationReportController';
  $scope.$parent.$watch('showDiv', function(value){
		
		if(value == 5){
			
			$scope.getAllAvgDays();
		}
		
	});
  
  $scope.getDays = function(){
	  DataService.getAvgDays($scope.userName).then(function(response){
		  console.log(response.data);
		  $scope.avgDays = response.data;
	  });
  }
  
  $scope.getAllAvgDays = function(){
	  $scope.$parent.loader.loading = true;
	  DataService.getAllAvgDays().then(function(response){
		  //console.log(response.data);
		  $scope.$parent.loader.loading = false;
		  $scope.allUsers = response.data;
		 // $scope.avgDays = response.data;
	  });
  }
  
});