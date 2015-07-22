//package com.test.organizer.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.test.organizer.entity.Event;
//import com.test.organizer.service.EventService;
//
//@Controller
//public class EventController {
//
//	@Autowired
//	EventService eventService;
//	
//	@RequestMapping(value = {"/newevent"}, method = RequestMethod.GET)
//	public String createEvent(ModelMap model){
//		Event event = new Event();
//		model.addAttribute(event);
//		return "event";
//	}
//	
//	@RequestMapping(value = {"/newevent"}, method = RequestMethod.POST)
//	public String saveEvent(Event event){
//		eventService.saveEvent(event);
//		return "registrationcomleted";
//	}
//}
