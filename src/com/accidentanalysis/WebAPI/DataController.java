package com.accidentanalysis.WebAPI;


import java.util.ArrayList;  
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.*;

import com.accidentanalysis.DAL.*;
import com.accidentanalysis.Models.*;
import com.google.gson.Gson;  
  
@RestController  
public class DataController {  
   
@RequestMapping(value = "/citiesti", method = RequestMethod.GET,headers="Accept=application/json")  
 public String getCities()  
 {  
		 
		List<City> cities = new ArrayList<City>();
		
		cities = new TestDBData().GetData();
		
	  	Gson g = new Gson(); 	
	  	
	  	return g.toJson(cities);  
 }  
	  
@RequestMapping(value = "/getTrendAnalysis", method = RequestMethod.GET,headers="Accept=application/json")  
public String getTrendAnalysis()  
{  
		 
		List<Trend> trends;
		
		  trends = new APIDBAccess().GetTrendData();
		//Trend t = new Trend(20,33);
		//trends.add(t);
		  System.out.println("get trends");
	  	Gson g = new Gson(); 	
	  	
	  	return g.toJson(trends);  
}  
	
@RequestMapping(value = "/report", method = RequestMethod.POST,headers="Accept=application/json")  
public String reportIncidents(@RequestBody Incident incident,HttpSession session)  
{  
	   User user = (User)session.getAttribute("userlogin");
        String message = new IncidentDBAccess().reportIncident(incident,user).toString();
        Gson g = new Gson(); 	
	  	
	  	return g.toJson(message); 
	  	  
}  

@RequestMapping(value = "/getCorrelations", method = RequestMethod.GET,headers="Accept=application/json")  
public String getCorrelation()  
{  
		 
		List<Correlation> correlations;
		CorrelationDBAccess correlationDBAccess = new CorrelationDBAccess();
		
		correlations = correlationDBAccess.GetCorrelationData();
		System.out.println("get correlations");
	  	Gson g = new Gson(); 	
	  	
	  	return g.toJson(correlations);  
} 
   
  

}  
