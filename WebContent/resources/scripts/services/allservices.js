myApp.service('DataService', function($http) {
    this.getCountryList = function(){
	
    	var promise = $http({
            method : "GET",
            url : "/AccidentAnalysis/api/countries"
        });
    	return promise;
	}
    
});