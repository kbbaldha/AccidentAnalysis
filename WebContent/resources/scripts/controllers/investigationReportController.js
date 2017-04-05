
myApp.controller('investigationReportController',  function($scope,DataService) {
  $scope.name = 'investigationReportController';
  $scope.$parent.$watch('showDiv', function(value){
		
		if(value == 5){
			
			//$scope.getDays();
		}
		
	});
  
  $scope.getDays = function(){
	  DataService.getAvgDays($scope.userName).then(function(response){
		  console.log(response.data);
		  $scope.avgDays = response.data;
	  });
  }
  
});