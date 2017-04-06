
myApp.controller('accidentPredictionController',  function($scope,DataService) {
  $scope.name = 'accidentPredictionController';
  	$scope.$parent.$watch('showDiv', function(value){
	
  		if(value == 2){
  			
  			$scope.getPrediction();
  		}
  		
  	});
  	
  	
  	
  	$scope.getPrediction = function(){
  		
  		 $scope.$parent.loader.loading = true;
   		DataService.getPrediction().then(function(response){
  			 $scope.$parent.loader.loading = false;
 			  $scope.drawChart($scope.makeDataPoints(response.data));
  			//$scope.drawGoogleChart($scope.makeGoogleDataPoints(response.data));
  		},function(err){console.log(err)});
  	}
  	
  	$scope.makeDataPoints = function(data){
  	  
		 var dpoints = [];
		 for(var i=0;i<data.length;i++){
			 var d = data[i];
			 dpoints.push({
				 label: d.year, 
				 y: d.noOfAccidents
			 });
		 }
		 return dpoints;
		 
	  }
  	
  	$scope.makeGoogleDataPoints = function(data){
    	  
		 var dpoints = [];
		 dpoints.push(["year","numOfAccidents",{role:'style'}]);
		  for(var i=0;i<data.length;i++){
			 var d = data[i];
			 var row = [];
			 row.push(
				 d.year, 
				 d.noOfAccidents,
				 { color:'red'}
			 );
			 dpoints.push(row);
		 }
		 return dpoints;
		 
	  }
 
 $scope.drawChart = function(dpoints){
	  
	  var chart = new CanvasJS.Chart("accidentPredictionContainer",
			    {
			      theme: "theme2",
			      title:{
			        text: "Accident Prediction Report"
			      },
			      animationEnabled: true,
			      axisX: {
			    	title: "Years",
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
 
 $scope.drawGoogleChart = function(dpoints){
	 
	      var data = google.visualization.arrayToDataTable(dpoints);

	      var view = new google.visualization.DataView(data);
	      view.setColumns([0, 1,
	                       { calc: "stringify",
	                         sourceColumn: 1,
	                         type: "string",
	                         role: "annotation" },
	                       2]);

	      var options = {
	        title: "Density of Precious Metals, in g/cm^3",
	        width: 600,
	        height: 400,
	        bar: {groupWidth: "95%"},
	        legend: { position: "none" },
	      };
	      var chart = new google.visualization.ColumnChart(document.getElementById("accidentPredictionContainer"));
	      chart.draw(view, options);
	  
	 
 }
  	
  	$scope.getCities = function(){
  		//console.log($scope.$parent.loader.loading);
  		$scope.$parent.loader.loading = true;
  		DataService.getCityList().then(function(response){
  			//console.log($scope.$parent.loader.loading);
  			$scope.$parent.loader.loading = false;
  			$scope.cities = response.data;
  			//alert(response.data);
  			
  		},function(error){
  			$scope.$parent.loader.loading = false;
  		})
  	}
});