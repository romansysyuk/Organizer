package com.test.organizer.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.organizer.dao.EventDao;
import com.test.organizer.entity.Event;
import com.test.organizer.service.EventService;

@Service("eventService")
@Transactional
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDao eventDao;

	@Override
	public Event getEventById(int id) {
		Event event = eventDao.getById(id);
		return event;
	}

	@Override
	public List<Event> getEventByName(String eventName) {
		List<Event> events = eventDao.getByEventName(eventName);
		return events;
	}

	@Override
	public List<Event> getEventByDate(Date eventDate) {
		List<Event> events = eventDao.getByEventDate(eventDate);
		return events;
	}

	@Override
	public List<Event> getAllEvents() {
		List<Event> allEvents = eventDao.getAll();
		return allEvents;
	}

	@Override
	public boolean saveEvent(Event event) {
		eventDao.save(event);
		return true;
	}

	@Override
	public boolean updateEvent(Event event) {
		eventDao.update(event);
		return true;
	}

	@Override
	public boolean deleteEvent(Event event) {
		eventDao.delete(event);
		return true;
	}

	@Override
	public List<Event> getEventByUsername(String username) {
		return eventDao.getByUsername(username);
	}

}
