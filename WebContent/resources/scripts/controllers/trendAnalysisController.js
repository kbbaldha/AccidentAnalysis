
myApp.controller('trendAnalysisController',  function($scope,DataService) {
  $scope.name = 'trendAnalysisController';
  
  $scope.$parent.$watch('showDiv', function(value){
		
		if(value == 4){
			
			$scope.getData();
		}
		
	});
  
  $scope.getData = function(data){
	  $scope.$parent.loader.loading = true;
	  DataService.getTrendAnalysis().then(function(response){
		  $scope.$parent.loader.loading = false;
		  $scope.drawChart($scope.makeDataPoints(response.data)); 
		 
	  });
	  
	  
	  
  }
  
  $scope.yearChange = function(){
	  console.log($scope.selectedYear);
	  var year = $scope.selectedYear;
	  $scope.getMonthData(year);
  }
  
  $scope.getMonthData = function(year){
	  $scope.$parent.loader.loading = true;
	  
	  DataService.getTrendByMonth(year).then(function(response){
		  $scope.$parent.loader.loading = false;
		  //console.log(response.data);
		  //console.log($scope.makeMonthPoints(response.data,year));
		  $scope.drawMonthChart($scope.makeMonthPoints(response.data,year)); 
		 
	  });
  }
  
  $scope.makeMonthPoints = function(data,year){
	  var dpoints = [];
		 var max = -1;
		 var min = 1000000000000;
		 for(var i=0;i<data.length;i++){
			 var d = data[i];
			 if(max < d.noOfAccidents){
				 max = d.noOfAccidents;
				 
			 }
			 if(min > d.noOfAccidents){
				 min = d.noOfAccidents;
				 
			 }
			 dpoints.push({
				 x: new Date(year, d.month-1, 1), 
				 y: d.noOfAccidents
			 });
		 }
		 
		 dpoints = dpoints.map(function(item,idx){
			 if(item.y == max){
				 item.indexLabel = "highest";
				 item.markerColor= "red";
				 item.markerType = "triangle"
			 }
			 else if(item.y == min){
				 item.indexLabel = "lowest";
				 item.markerColor= "DarkSlateGrey";
				 item.markerType = "cross"
			 }
			 return item;
		 });
		 return dpoints;
		
  }
  
$scope.drawMonthChart = function(dpoints){
	  
	  var chart = new CanvasJS.Chart("chartContainer",
			    {
			      theme: "theme2",
			      title:{
			        text: "Accidents - per month"
			      },
			      animationEnabled: true,
			      axisX: {
			        valueFormatString: "MMM",
			        interval:1,
			        intervalType: "month"
			        
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
  
  $scope.makeDataPoints = function(data){
	  
	
	 var dpoints = [];
	 var max = -1;
	 var min = 1000000000000;
	 $scope.years = [];
	 for(var i=0;i<data.length;i++){
		 var d = data[i];
		 $scope.years.push(d.Year);
		 
		 if(max < d.noOfAccidents){
			 max = d.noOfAccidents;
			 
		 }
		 if(min > d.noOfAccidents){
			 min = d.noOfAccidents;
			 
		 }
		 dpoints.push({
			 x: new Date(d.Year, 01, 1), 
			 y: d.noOfAccidents
		 });
	 }
	 
	 dpoints = dpoints.map(function(item,idx){
		 if(item.y == max){
			 item.indexLabel = "highest";
			 item.markerColor= "red";
			 item.markerType = "triangle"
		 }
		 else if(item.y == min){
			 item.indexLabel = "lowest";
			 item.markerColor= "DarkSlateGrey";
			 item.markerType = "cross"
		 }
		 return item;
	 });
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