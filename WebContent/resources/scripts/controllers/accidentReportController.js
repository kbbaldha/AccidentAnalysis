
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

		$scope.incident = {};
		$scope.incident.numofteammambers = $scope.numofteammembers;
		$scope.incident.eventtype = $scope.incidenttype;
		$scope.incident.eventsubtype = $scope.incidentsubtype;
		$scope.incident.latitude = $scope.latitude;
		$scope.incident.longitude = $scope.logitude;
		DataService.reportIncidents($scope.incident).then(function(response){
			$scope.message = response.data;
			$scope.reset();
		},function(error){
			//$scope.$parent.loader.loading = false;
		})
	}
	
	$scope.reset = function(){
        $scope.numofteammembers ="";
        $scope.incidenttype="";
        $scope.incidentsubtype="";
        $scope.latitude="";
        $scope.logitude="";       
     }
});