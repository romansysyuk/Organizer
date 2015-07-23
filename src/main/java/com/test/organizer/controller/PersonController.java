package com.test.organizer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.organizer.entity.Person;
import com.test.organizer.service.PersonService;

@Controller
public class PersonController {

	@Autowired
	PersonService personService;

	@RequestMapping(value = { "/newperson**" }, method = RequestMethod.GET)
	public String newPerson(ModelMap model) {
		Person person = new Person();
		model.addAttribute("person", person);
		return "registration";
	}

	@RequestMapping(value = { "/newperson**" }, method = RequestMethod.POST)
	public String savePerson(Person person) {
		personService.savePerson(person);
		return "registrationcomleted";
	}

	// Spring Security see this :
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}
	// @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
	// public String login(){
	// return "login";
	// }
	//
	// @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
	// public String loginSuccess(){
	// return "registrationcomleted";
	// }
}
