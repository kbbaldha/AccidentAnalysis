myApp.service('DataService', function($http) {
    this.getCountryList = function(){
	
    	var promise = $http({
            method : "GET",
            url : "/AccidentAnalysis/api/countries"
        });
    	return promise;
	}
    
    this.getCityList = function(){
    	
    	var promise = $http({
            method : "GET",
            url : "/AccidentAnalysis/api/cities"
        });
    	return promise;
	}
    this.getTrendAnalysis = function(){
    	
    	var promise = $http({
            method : "GET",
            url : "/AccidentAnalysis/api/getTrendAnalysis"
        });
    	
    	return promise;
    }
    this.getMapLocations = function(){
    	var promise = $http({
            method : "GET",
            url : "/AccidentAnalysis/api/getMapLocations"
        });
    	
    	return promise;
    }
    
});