package com.test.organizer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class MainController {
 
	@RequestMapping(value = "/home**", method = RequestMethod.GET)
	public ModelAndView adminPage() {
 
	  ModelAndView model = new ModelAndView();
	  model.setViewName("home");
	  return model;
 
	}
}