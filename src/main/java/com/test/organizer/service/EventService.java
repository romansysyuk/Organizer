package com.test.organizer.service;

import java.util.Date;
import java.util.List;

import com.test.organizer.entity.Event;

public interface EventService {
	Event getEventById(int id);

	List<Event> getEventByName(String eventName);
	
	List<Event> getEventByUsername(String username);

	List<Event> getEventByDate(Date eventDate);

	List<Event> getAllEvents();

	boolean saveEvent(Event event);

	boolean updateEvent(Event event);

	boolean deleteEvent(Event event);
}
