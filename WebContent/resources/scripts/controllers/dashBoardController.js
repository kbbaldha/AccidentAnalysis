myApp.controller('dashBoardController',  function($scope,DataService) {
  $scope.name = 'dashBoardController';
  	$scope.$parent.$watch('showDiv', function(value){
	
  		if(value == 8){
  			
  			$scope.getCars();
  			$scope.getAvgSpeed();
  			$scope.getInvestigationPeriod();
  		}
  		
  	});
  	
  		
  	$scope.getCars = function(){
  		
  		 $scope.$parent.loader.loading = true;
  		 DataService.getCars().then(function(response){
  			 $scope.$parent.loader.loading = false;
 			  $scope.drawChart($scope.makeDataPoints(response.data));
  		},function(err){console.log(err)});
  	}
  	
	$scope.getAvgSpeed = function(){
  		
 		 $scope.$parent.loader.loading = true;
 		DataService.getAvgSpeed().then(function(response){
 			 $scope.$parent.loader.loading = false;
			  $scope.Speed = response.data;
 		},function(err){console.log(err)});
 	}
	
	$scope.getInvestigationPeriod = function(){
  		
 		 $scope.$parent.loader.loading = true;
 		DataService.getInvestigationPeriod().then(function(response){
 			 $scope.$parent.loader.loading = false;
 			$scope.InvestigationPeriod = response.data;
 		},function(err){console.log(err)});
 	}
  	
  	$scope.makeDataPoints = function(data){
  	  
		 var dpoints = [];
		 for(var i=0;i<data.length;i++){
			 var d = data[i];
			  dpoints.push({
				 label: d.make, 
				 y: d.count
			 });
		 }
		 return dpoints;
		 
	  }
 
 $scope.drawChart = function(dpoints){
	  
	  var chart = new CanvasJS.Chart("dashBoardContainer",
			    {
			      theme: "theme2",
			      title:{
			        text: "Cars involved"
			      },
			      animationEnabled: true,
			      axisX: {
			    	title: "Brand",
			      },
			      axisY:{
			       title: "No of accidents"			        
			      },
			      data: [
			      {        
			    	  type: "column",  	             
			          dataPoints: dpoints
			      }
			      
			      
			      ]
			    });
			chart.render();
 }

});