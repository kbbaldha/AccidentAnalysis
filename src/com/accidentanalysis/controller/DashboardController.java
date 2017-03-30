package com.accidentanalysis.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accidentanalysis.DAL.IncidentDBAccess;
import com.accidentanalysis.DAL.UserDbAccess;
import com.accidentanalysis.Models.Incident;
import com.accidentanalysis.Models.User;

public class DashboardController {
	
	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public ModelAndView report() {
 
		//String message = "logout";// new TestDBData().GetData();
		
		return new ModelAndView("welcome");
	}
	
	@RequestMapping(value = "/report", method = RequestMethod.POST)
	public ModelAndView reportSubmit(@ModelAttribute Incident incident,HttpSession session) {
 
		System.out.println("incident report");
		IncidentDBAccess incidentDBAccess =  new IncidentDBAccess();
		
		String dbincident = incidentDBAccess.reportIncident(incident).toString();
		
		System.out.println("incident report string buffer message" + dbincident);
		
		if(dbincident.length()<=0){
			
		//System.out.println(user.getGender());
			return new ModelAndView("welcome");
		}
		
		return new ModelAndView("welcome");
	}

}
