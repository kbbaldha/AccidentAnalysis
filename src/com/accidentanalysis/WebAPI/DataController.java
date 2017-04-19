package com.accidentanalysis.WebAPI;


import java.sql.SQLException;
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
	
@RequestMapping(value = "/getMapLocations", method = RequestMethod.GET,headers="Accept=application/json")  
public String getMapLocations()  
{ 
	List<MapLocation> locations;
	
	locations = new APIDBAccess().GetMapLocationData();
	
	  
	Gson g = new Gson(); 	
	
	return g.toJson(locations);  
	
}
  @RequestMapping(value = "/report", method = RequestMethod.POST,headers="Accept=application/json")  
public String reportIncidents(@RequestBody Incident incident,HttpSession session)  
{  
	   User user = (User)session.getAttribute("userlogin");
        String message = new IncidentDBAccess().reportIncident(incident,user).toString();
        Gson g = new Gson(); 
        return g.toJson(message); 	
} 
@RequestMapping(value = "/getPrediction", method = RequestMethod.GET,headers="Accept=application/json")  
public String getPrediction()  
{  
	List<Prediction> predictions;
	AccidentPredictionDBAccess accidentPredictionDBAccess = new AccidentPredictionDBAccess();
	
	predictions = accidentPredictionDBAccess.getAccidentPredictionData();
	System.out.println("prediction data");
  	Gson g = new Gson(); 	
  	
  	return g.toJson(predictions);  
} 
@RequestMapping(value = "/getAvgDays/{UserName}", method = RequestMethod.GET,headers="Accept=application/json")  
public String getAvgDays(@PathVariable String UserName)  
{
	System.out.println(UserName);
	 int days = 0;
	 try{
		 days = new APIDBAccess().GetAvgDays(UserName.trim());
	 }
	 catch(Exception e){
		 days = -1;
	 }
	 Gson g = new Gson(); 	
	  	
	 return g.toJson(days);  
}
@RequestMapping(value = "/getAllAvgDays/", method = RequestMethod.GET,headers="Accept=application/json")  
public String getAllAvgDays()  
{
	//System.out.println(UserName);
	 List<UserAvgDays> avgdays = null;
	 try{
		 avgdays = new APIDBAccess().GetAvgDays();
	 }
	 catch(Exception e){
		 //days = -1;
		 System.out.println(e.getMessage());
	 }
	 Gson g = new Gson(); 	
	  	
	 return g.toJson(avgdays);  
}

@RequestMapping(value = "/getTrendByMonth/{Year}", method = RequestMethod.GET,headers="Accept=application/json")  
public String getTrendByYear(@PathVariable int Year)  
{
	List<Trend> trends;
	
	  trends = new APIDBAccess().GetTrendData(Year);
	  System.out.println("get trends");
	Gson g = new Gson(); 	
	
	return g.toJson(trends); 
}

@RequestMapping(value = "/getTableData/", method = RequestMethod.GET,headers="Accept=application/json")  
public String getTableData()  
{
	//System.out.println(UserName);
	 List<TableInfo> tables = null;
	 try{
		 tables = new APIDBAccess().GetTableData();
	 }
	 catch(Exception e){
		 System.out.println(e.getMessage());
	 }
	 Gson g = new Gson(); 	
	  	
	 return g.toJson(tables);  

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

@RequestMapping(value = "/getCars", method = RequestMethod.GET,headers="Accept=application/json")  
public String getCars()  
{  
		 
		List<Car> cars;
		DashboardDBAccess dashboardDBAccess = new DashboardDBAccess();
		
		cars = dashboardDBAccess.getCarsInvolvedInAccident();
		System.out.println("get CArs");
	  	Gson g = new Gson(); 	
	  	
	  	return g.toJson(cars);  
}

@RequestMapping(value = "/getInvestigationPeriod", method = RequestMethod.GET,headers="Accept=application/json")  
public String getInvestigationPeriod()  
{  
		 
		
		DashboardDBAccess dashboardDBAccess = new DashboardDBAccess();
		
		int investigationPeriod = dashboardDBAccess.getInvestigationPeriod();
		System.out.println("get CArs");
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("The average investigation period of each incident has been " + investigationPeriod +" days");
	  	Gson g = new Gson(); 	
	  	
	  	return g.toJson(stringBuffer.toString());  
} 
@RequestMapping(value = "/getAvgSpeed", method = RequestMethod.GET,headers="Accept=application/json")  
public String getAvgSpeed()  
{  		
		DashboardDBAccess dashboardDBAccess = new DashboardDBAccess();
		
		int avgSpeed = dashboardDBAccess.getAvgSpeed();
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("The average overspeeding of the cars during each incident is by " + avgSpeed +" mph");
	  	Gson g = new Gson(); 	
	  	
	  	return g.toJson(stringBuffer.toString());   
} 

@RequestMapping(value = "/getCorelationData", method = RequestMethod.GET,headers="Accept=application/json")  
public String getCorelationData()  
{  
		 
		CorelationData correlations;
		CorrelationDBAccess correlationDBAccess = new CorrelationDBAccess();
		
		correlations = correlationDBAccess.GetCorrelation();
		System.out.println("get correlations");
	  	Gson g = new Gson(); 	
	  	
	  	return g.toJson(correlations);  
} 


}  
