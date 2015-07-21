package com.test.organizer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.organizer.entity.Person;
import com.test.organizer.service.PersonService;

@Controller
public class PersonController {

	@Autowired
	PersonService personService;
	
	@RequestMapping(value = {"/newperson"}, method = RequestMethod.GET)
	public String newPerson(ModelMap model){
		Person person = new Person();
		model.addAttribute("person", person);		
		return "registration";
	}
	
	@RequestMapping(value = {"/newperson"}, method = RequestMethod.POST)
	public String savePerson(Person person){
		personService.savePerson(person);
		return "registrationcomleted";
	}
	
	@RequestMapping(value = {"/login"}, method = RequestMethod.GET)
	public String login(){
		return "loginpage";
	}
	
	@RequestMapping(value = {"/login"}, method = RequestMethod.POST)
	public String loginSuccess(){
		return "registrationcomleted";
	}
}
