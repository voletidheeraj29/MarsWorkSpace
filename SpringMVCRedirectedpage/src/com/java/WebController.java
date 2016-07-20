package com.java;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	public String redirect() {
		return "redirect:finalpage";
	}

	@RequestMapping(value = "/finalpage", method = RequestMethod.GET)
	public String finalpage() {
		return "finalpage";
	}

}
