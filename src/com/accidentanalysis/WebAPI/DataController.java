package com.accidentanalysis.WebAPI;


import java.sql.SQLException;
import java.util.ArrayList;  
import java.util.List;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RestController;

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
   
@RequestMapping(value = "/getPrediction", method = RequestMethod.GET,headers="Accept=application/json")  
public String getPrediction()  
{  
		 
		
		
		  int x= 0;
		  List<Trend> objcts = null;
		try {
			objcts = new APIDBAccess().GetPrediction();
			x = 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		  //System.out.println("get trends");
	  	Gson g = new Gson(); 	
	  	
	  	return g.toJson(objcts);  
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



}  
