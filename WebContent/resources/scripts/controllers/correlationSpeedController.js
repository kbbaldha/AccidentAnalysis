
myApp.controller('correlationSpeedController',  function($scope,DataService) {
  $scope.name = 'correlationSpeedController';
  
  $scope.$parent.$watch('showDiv', function(value){
		
		if(value == 3){
			
			$scope.getData();
			$scope.getCorelation();
			}
		
	});
  
  $scope.getData = function(data){
	  $scope.$parent.loader.loading = true;
	  DataService.getCorrelations().then(function(response){
		  $scope.$parent.loader.loading = false;
		  $scope.drawChart($scope.makeDataPoints(response.data)); 
		 
	  });
	  
  }
  $scope.getCorelation = function(data){
	  DataService.getCorelationData().then(function(response){
		$scope.Corelation = response.data.message +".The calculated correlation value is "+ response.data.corelation;
	  });
	  
  }
  
  $scope.makeDataPoints = function(data){
		 var dpoints = [];
		 for(var i=0;i<data.length;i++){
			 var d = data[i];
			 dpoints.push({
				 x: d.speed, 
				 y: d.avgNumAccidents
			 });
		 }
		 return dpoints;
	  }
  
  $scope.drawChart = function(dpoints){
	  
	  var chart = new CanvasJS.Chart("scatterChartContainer",
			    {
			      theme: "theme2",
			      title:{
			        text: "Speed vs Accident"
			      },
			      animationEnabled: true,
			      axisX: {
			    	title: "Speed in mph",
			        suffix: "mph"
			        
			      },
			      axisY:{
			       title: "Accidents count accross 10 years"			        
			      },
			      data: [
			      {        
			        type: "scatter",       
			        dataPoints: dpoints
			      }
			      
			      
			      ]
			    });
			chart.render();
  }
  
  
});