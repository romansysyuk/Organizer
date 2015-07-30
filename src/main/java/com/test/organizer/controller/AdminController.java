package com.test.organizer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.organizer.service.EventService;
import com.test.organizer.service.UserInfoService;
import com.test.organizer.service.UserService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	@Autowired
	EventService eventService;

	@Autowired
	UserService userService;

	@Autowired
	UserInfoService userInfoService;

	@RequestMapping(value = { "/allEvents" }, method = RequestMethod.GET)
	public ModelAndView allEvents() {
		ModelAndView model = new ModelAndView("allEvents");
		model.addObject("events", eventService.getAllEvents());
		return model;
	}

	@RequestMapping(value = { "/deleteEvent/{eventId}" }, method = RequestMethod.GET)
	public String deleteEvent(@PathVariable("eventId") int eventId) {
		eventService.deleteEvent(eventService.getEventById(eventId));
		return "redirect:/admin/allEvents";
	}

	@RequestMapping(value = { "/allUsers" }, method = RequestMethod.GET)
	public ModelAndView allUsers() {
		ModelAndView model = new ModelAndView("allUsers");
		model.addObject("users", userInfoService.getAllPersons());
		return model;
	}

	@RequestMapping(value = { "/deleteUser/{userId}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable("userId") int userId) {
		userService.deleteUser(userService.findById(userId));
		return "redirect:/admin/allUsers";
	}
}
