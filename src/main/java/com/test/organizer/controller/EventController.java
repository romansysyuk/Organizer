package com.test.organizer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.organizer.entity.Event;
import com.test.organizer.service.EventService;
import com.test.organizer.service.UserInfoService;
import com.test.organizer.service.UserService;

@Controller
public class EventController {

	@Autowired
	EventService eventService;

	@Autowired
	UserService userService;
	
	@Autowired
	UserInfoService userInfoService;

	@RequestMapping(value = { "/newEvent" }, method = RequestMethod.GET)
	public String createEvent(ModelMap model) {
		Event event = new Event();
		model.addAttribute(event);
		return "newEvent";
	}

	@RequestMapping(value = { "/myEvents" }, method = RequestMethod.POST)
	public ModelAndView saveEvent(Event event) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		event.setUser(userService.findByUserName(username));
		eventService.saveEvent(event);
		ModelAndView model = new ModelAndView("myEvents");
		model.addObject("events", eventService.getEventByUsername(username));
		return model;
	}

	@RequestMapping(value = { "/admin/allEvents" }, method = RequestMethod.GET)
	public ModelAndView allEvents() {
		ModelAndView model = new ModelAndView("allEvents");
		model.addObject("events", eventService.getAllEvents());
		return model;
	}

	@RequestMapping(value = { "/admin/deleteEvent/{eventId}" }, method = RequestMethod.GET)
	public String deleteEvent(@PathVariable("eventId") int eventId) {
		eventService.deleteEvent(eventService.getEventById(eventId));
		return "redirect:/admin/allEvents";
	}
	
	@RequestMapping(value = { "/admin/allUsers" }, method = RequestMethod.GET)
	public ModelAndView allUsers() {
		ModelAndView model = new ModelAndView("allUsers");
		model.addObject("users", userInfoService.getAllPersons());
		return model;
	}

	@RequestMapping(value = { "/admin/deleteUser/{userId}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable("userId") int userId) {
		userService.deleteUser(userService.findById(userId));
		return "redirect:/admin/allUsers";
	}
}
