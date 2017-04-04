
myApp.controller('safeNavigationController',  function($scope,DataService) {
  $scope.name = "safeNavigationController";
  $scope.clickNo = 0;
  $scope.$parent.$watch('showDiv', function(value){
		
		if(value == 1){
			
			$scope.initMap();
		}
		
	});
  
  
  $scope.initMap = function() {
	  $scope.$parent.loader.loading = true;
	  DataService.getMapLocations().then(function(response){
		  $scope.locations = response.data;
		  //console.log($scope.locations);
		  $scope.$parent.loader.loading = false;
		  $scope.locations = $scope.locations.map(function(loc){
			  
			  return {
				  lat:loc.Latitude,
				  lng:loc.Longitude
			  }
			  
		  });
		  $scope.map = new google.maps.Map(document.getElementById('map'), {
			    zoom: 10,
			    center: {lat: 38.908883, lng: -77.026938}
			  });
		  $scope.directionsService = new google.maps.DirectionsService();
		  $scope.directionsDisplay = new google.maps.DirectionsRenderer();
		  $scope.directionsDisplay.setMap($scope.map);
		  
		     google.maps.event.addListener($scope.map, "click", function (event) {
		    	    var latitude = event.latLng.lat();
		    	    var longitude = event.latLng.lng();
		    	    console.log( latitude + ', ' + longitude );
		    	    $scope.clickNo++;
		    	    if($scope.clickNo % 2 != 0){
		    	    	$scope.pos1 = new google.maps.LatLng(latitude, longitude);
		    	    	
		    	    }
		    	    else{
		    	    	$scope.pos2 = new google.maps.LatLng(latitude, longitude);
		    	    	$scope.routeFinder();
		    	    }
		     });
			  // Create an array of alphabetical characters used to label the markers.
			  var labels = 'A';

			  // Add some markers to the map.
			  // Note: The code uses the JavaScript Array.prototype.map() method to
			  // create an array of markers based on a given "locations" array.
			  // The map() method here has nothing to do with the Google Maps API.
			  var markers = $scope.locations.map(function(location, i) {
			    return new google.maps.Marker({
			      position: location,
			      label: labels[i % labels.length]
			    });
			  });

			  // Add a marker clusterer to manage the markers.
			  var markerCluster = new MarkerClusterer($scope.map, markers,{imagePath: 'https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/m'});

	  });

}
  
  $scope.routeFinder = function(){
	  var directionsDisplay;
	 
	  var request = {
		      origin: $scope.pos1,
		      destination: $scope.pos2,
		      travelMode: 'DRIVING'
		    };
	  $scope.directionsService.route(request, function(result, status) {
		      if (status == 'OK') {
		        $scope.directionsDisplay.setDirections(result);
		      }
		});
	  
	  

	  
	  
  }
  
	/*$scope.locations = [
	  {lat: -31.563910, lng: 147.154312},
	  {lat: -33.718234, lng: 150.363181},
	  {lat: -33.727111, lng: 150.371124},
	  {lat: -33.848588, lng: 151.209834},
	  {lat: -33.851702, lng: 151.216968},
	  {lat: -34.671264, lng: 150.863657},
	  {lat: -35.304724, lng: 148.662905},
	  {lat: -36.817685, lng: 175.699196},
	  {lat: -36.828611, lng: 175.790222},
	  {lat: -37.750000, lng: 145.116667},
	  {lat: -37.759859, lng: 145.128708},
	  {lat: -37.765015, lng: 145.133858},
	  {lat: -37.770104, lng: 145.143299},
	  {lat: -37.773700, lng: 145.145187},
	  {lat: -37.774785, lng: 145.137978},
	  {lat: -37.819616, lng: 144.968119},
	  {lat: -38.330766, lng: 144.695692},
	  {lat: -39.927193, lng: 175.053218},
	  {lat: -41.330162, lng: 174.865694},
	  {lat: -42.734358, lng: 147.439506},
	  {lat: -42.734358, lng: 147.501315},
	  {lat: -42.735258, lng: 147.438000},
	  {lat: -43.999792, lng: 170.463352}
	]*/
});