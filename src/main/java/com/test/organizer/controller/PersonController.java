package com.test.organizer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PersonController {

	@RequestMapping(value = {"/"})
	public String registrationPage(){		
		return "RegistrationPage";
	}
}
