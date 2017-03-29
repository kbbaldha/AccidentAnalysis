
myApp.controller('trendAnalysisController',  function($scope,DataService) {
  $scope.name = 'trendAnalysisController';
  
  $scope.$parent.$watch('showDiv', function(value){
		
		if(value == 4){
			
			$scope.getData();
		}
		
	});
  
  $scope.getData = function(data){
	  DataService.getTrendAnalysis().then(function(response){
		  console.log(response.data);
		  $scope.drawChart($scope.makeDataPoints(response.data)); 
	  });
	  
  }
  
  $scope.makeDataPoints = function(data){
	  
	 /*var dpoints = [
	        { x: new Date(2012, 01, 1), y: 450 },
	        { x: new Date(2013, 01, 1), y: 414},
	        { x: new Date(2014, 02, 1), y: 520, indexLabel: "highest",markerColor: "red", markerType: "triangle"},
	        { x: new Date(2015, 03, 1), y: 460 },
	        { x: new Date(2016, 04, 1), y: 450 },
	        { x: new Date(2017, 05, 1), y: 500 },
	        { x: new Date(2018, 06, 1), y: 480 },
	        { x: new Date(2019, 07, 1), y: 480 },
	        { x: new Date(2020, 08, 1), y: 410 , indexLabel: "lowest",markerColor: "DarkSlateGrey", markerType: "cross"},
	        { x: new Date(2020, 09, 1), y: 500 },
	        { x: new Date(2021, 10, 1), y: 480 },
	        { x: new Date(2022, 11, 1), y: 510 }
	        
	        ];*/
	 var dpoints = [];
	 for(var i=0;i<data.length;i++){
		 var d = data[i];
		 dpoints.push({
			 x: new Date(d.Year, 01, 1), 
			 y: d.noOfAccidents
		 });
	 }
	 
	 return dpoints;
	 
  }
  
  $scope.drawChart = function(dpoints){
	  
	  var chart = new CanvasJS.Chart("chartContainer",
			    {
			      theme: "theme2",
			      title:{
			        text: "Accidents - per year"
			      },
			      animationEnabled: true,
			      axisX: {
			        valueFormatString: "YYYY",
			        interval:1,
			        intervalType: "year"
			        
			      },
			      axisY:{
			        includeZero: false
			        
			      },
			      data: [
			      {        
			        type: "line",
			        //lineThickness: 3,        
			        dataPoints: dpoints
			      }
			      
			      
			      ]
			    });

			chart.render();
  }
  
});