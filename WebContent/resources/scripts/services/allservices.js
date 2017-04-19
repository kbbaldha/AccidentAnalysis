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
    
    
this.getCorrelations = function(){
    	
    	var promise = $http({
            method : "GET",
            url : "/AccidentAnalysis/api/getCorrelations"
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
    this.reportIncidents = function(incident){
       	var promise = $http({
            method : "POST",
            url : "/AccidentAnalysis/api/report",
            data:incident,
            headers: {'Content-Type': 'application/json'}
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
    this.getAllAvgDays = function(){
    	var promise = $http({
            method : "GET",
            url : "/AccidentAnalysis/api/getAllAvgDays/" 
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
    this.getTrendByMonth = function(year){
    	var promise = $http({
            method : "GET",
            url : "/AccidentAnalysis/api/getTrendByMonth/" + year
        });    	
    	return promise;
    }
});