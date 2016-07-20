package com.java;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorld {
@RequestMapping("/hello")
public  ModelAndView helloworld(){
	String message="Haii";
	return new ModelAndView("hellopage","message",message);
	
}
}
