package com.accidentanalysis.controller;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accidentanalysis.DAL.TestDBData;
import com.accidentanalysis.DAL.UserDbAccess;
import com.accidentanalysis.Models.User;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;

@Controller
public class HomeController {
	@RequestMapping("/welcome")
	public ModelAndView helloWorld(HttpSession session) {
 
		//String message = "<br><div style='text-align:center;'>"
			//	+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		String message = "hello welcome";// new TestDBData().GetData();
		User user = (User)session.getAttribute("userlogin");
		//if(null==user){
			//return new ModelAndView("login","message","Session Expired");
		//}
		return new ModelAndView("welcome", "message", message);
	}
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
 
		String message = "logout";// new TestDBData().GetData();
		
		session.removeAttribute("userlogin");
		
		return new ModelAndView("logout", "message", message);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
 
		//String message = "logout";// new TestDBData().GetData();
		
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginSubmit(@ModelAttribute User user,HttpSession session) {
 
		//String message = "logout";// new TestDBData().GetData();
	//	System.out.println(user.getUsername());
		UserDbAccess userDBAccess =  new UserDbAccess();
		
		User dbUser = userDBAccess.CheckUser(user);
		
		if(null != dbUser){
			session.setAttribute("userlogin",dbUser);
			return new ModelAndView("welcome");
		}
		
		return new ModelAndView("login","message", "Wrong username or password");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
 
		//String message = "logout";// new TestDBData().GetData();
		
		return new ModelAndView("register");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerSubmit(@ModelAttribute User user,HttpSession session) {
 
	
		UserDbAccess userDBAccess =  new UserDbAccess();
		
		User dbUser = userDBAccess.RegisterUser(user);
		
		if(null != dbUser){
			session.setAttribute("userlogin",dbUser);
		//System.out.println(user.getGender());
			return new ModelAndView("welcome");
		}
		
		return new ModelAndView("register","message", "Registration Failed Try again");
	}
}
