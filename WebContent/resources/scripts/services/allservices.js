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
    this.getPrediction = function(){
    	var promise = $http({
            method : "GET",
            url : "/AccidentAnalysis/api/getPrediction"
        });
    	
    	return promise;
    }
    this.getAvgDays = function(username){
    	var promise = $http({
            method : "GET",
            url : "/AccidentAnalysis/api/getAvgDays/" + username
        });
    	
    	return promise;

    }
    this.getTableData = function(){
    	var promise = $http({
            method : "GET",
            url : "/AccidentAnalysis/api/getTableData/"
        });
    	
    	return promise;
    }
});