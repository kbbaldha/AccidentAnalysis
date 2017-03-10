package com.accidentanalysis.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.accidentanalysis.DAL.TestDBData;

@Controller
public class HomeController {
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
 
		//String message = "<br><div style='text-align:center;'>"
			//	+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		String message = new TestDBData().GetData();
		
		return new ModelAndView("welcome", "message", message);
	}
}
