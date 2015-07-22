package com.test.organizer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.organizer.service.EventService;

@Controller
public class EventController {

	@Autowired
	EventService eventService;
	
	@RequestMapping(value = {"/newevent"}, method = RequestMethod.GET)
	public String createEvent(){
		return "event";
	}
	
}
