package com.java;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeWorld {
@RequestMapping("/welcome")
public ModelAndView welcome(){
	String message="Hello Welcome";
	return new ModelAndView("hellopage","message",message);
	
}
}
