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
    
this.reportIncidents = function(incident){
       	var promise = $http({
            method : "POST",
            url : "/AccidentAnalysis/api/report",
            data:incident,
            headers: {'Content-Type': 'application/json'}
        });
    	return promise;
    }
    
});