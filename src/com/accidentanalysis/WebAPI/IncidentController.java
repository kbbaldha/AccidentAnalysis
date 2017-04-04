package com.accidentanalysis.WebAPI;

import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accidentanalysis.DAL.APIDBAccess;
import com.accidentanalysis.DAL.IncidentDBAccess;
import com.accidentanalysis.DAL.UserDbAccess;
import com.accidentanalysis.Models.Incident;
import com.accidentanalysis.Models.Trend;
import com.accidentanalysis.Models.User;
import com.google.gson.Gson;

public class IncidentController {
	
	
//	@RequestMapping(value = "/report", method = RequestMethod.POST,headers="Accept=application/json")  
//	public String reportIncidents(@ModelAttribute Incident incident)  
//	{  
//			 
//			StringBuffer message;
//			
//			System.out.println("Incident Report");
//			  message = new IncidentDBAccess().reportIncident(incident);
//			
//		  	return message.toString();  
//	}  
}
