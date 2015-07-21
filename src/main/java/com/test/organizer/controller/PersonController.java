package com.test.organizer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.organizer.entity.Person;

@Controller
public class PersonController {

	@RequestMapping(value = {"/newperson"}, method = RequestMethod.GET)
	public String newPerson(ModelMap model){
		Person person = new Person();
		model.addAttribute("person", person);		
		return "registration";
	}
	
	@RequestMapping(value = {"/newperson"}, method = RequestMethod.POST)
	public String savePerson(){
		return "registrationcomleted";
	}
}
