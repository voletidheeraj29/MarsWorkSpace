package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
	@RequestMapping(value = "/hello")
	public ModelAndView helloworld(HttpServletRequest request, HttpServletResponse Response) {

		String name = request.getParameter("name");
		String password = request.getParameter("password");

		if (password.equals("admin")) {
			String message = "Hello"+  name;
			
			return new ModelAndView("hellopage", "message", message);
		} else {
			return new ModelAndView("error", "message", "Sorry invalid username and password");
		}

	}
}
