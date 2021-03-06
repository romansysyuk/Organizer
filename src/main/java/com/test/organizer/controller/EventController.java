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
@RequestMapping(value = "/event")
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
	
	@RequestMapping(value = { "/myEvents" }, method = RequestMethod.GET)
	public ModelAndView myEvents() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		ModelAndView model = new ModelAndView("myEvents");
		model.addObject("events", eventService.getUpcomingEvents(100000000));
		return model;
	}

	@RequestMapping(value = { "/newEvent" }, method = RequestMethod.POST)
	public ModelAndView saveEvent(Event event) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		event.setUser(userService.findByUserName(username));
		eventService.saveEvent(event);
		ModelAndView model = new ModelAndView("myEvents");
		model.addObject("events", eventService.getEventByUsername(username));
		return model;
	}
	
	@RequestMapping(value = { "/deleteEvent/{eventId}" }, method = RequestMethod.GET)
	public String deleteEvent(@PathVariable("eventId") int eventId) {
		eventService.deleteEvent(eventService.getEventById(eventId));
		return "redirect:/event/myEvents";
	}
	
	@RequestMapping(value="/editEvent/{eventId}", method = RequestMethod.GET)
	public ModelAndView editEventPage(@PathVariable("eventId") int eventId){
		ModelAndView model = new ModelAndView("editEvent");
		Event event = eventService.getEventById(eventId);
		model.addObject("event", event);
		return model;
		
	}
	
	@RequestMapping(value = {"/editEvent/{eventId}"}, method = RequestMethod.POST)
	public String editEvent(Event event){
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		event.setUser(userService.findByUserName(username));
		eventService.updateEvent(event);
		return "editEvent";
	}

	
}
