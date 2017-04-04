
myApp.controller('accidentReportController',  function($scope,DataService) {
  $scope.name = 'accidentReportController';
  
  $scope.incident = 
  $scope.$parent.$watch('showDiv', function(value){
		
		if(value == 6){
			
			//$scope.reportIncidents();
		}
		
	});
	
  	$scope.incident=[]
	
	
	$scope.submit= function(data){
//		console.log($scope.$parent.loader.loading);
		//$scope.$parent.loader.loading = true;
		$scope.incident = {};
		$scope.incident.reporterid = $scope.reporterid;
		$scope.incident.numofteammambers = $scope.numofteammembers;
		$scope.incident.eventtype = $scope.incidenttype;
		$scope.incident.eventsubtype = $scope.incidentsubtype;
		$scope.incident.latitude = $scope.latitude;
		$scope.incident.longitude = $scope.logitude;
		alert($scope.incident.reporterid);
		alert($scope.incident.numofteammambers);
		DataService.reportIncidents($scope.incident).then(function(response){
			//console.log($scope.$parent.loader.loading);
			//$scope.$parent.loader.loading = false;
			$scope.message = response.data;
			
		},function(error){
			$scope.$parent.loader.loading = false;
		})
	}
	
	$scope.reset = function(){
        $scope.reporterid = "";
       
     }
});