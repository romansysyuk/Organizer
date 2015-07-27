package com.test.organizer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.organizer.entity.Event;
import com.test.organizer.service.EventService;
import com.test.organizer.service.UserService;

@Controller
public class EventController {

	@Autowired
	EventService eventService;

	@Autowired
	UserService userService;

	@RequestMapping(value = { "/newevent" }, method = RequestMethod.GET)
	public String createEvent(ModelMap model) {
		Event event = new Event();
		model.addAttribute(event);
		return "event";
	}

	@RequestMapping(value = { "/myevents" }, method = RequestMethod.POST)
	public ModelAndView saveEvent(Event event) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		event.setUser(userService.findByUserName(username));
		eventService.saveEvent(event);
		ModelAndView model = new ModelAndView("myevents");
		model.addObject("events", eventService.getEventByUsername(username));
		return model;
	}
}
