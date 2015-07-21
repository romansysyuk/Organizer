package com.test.organizer.dao;

import java.util.Date;
import java.util.List;

import com.test.organizer.entity.Event;

public interface EventDao extends AbstractDao<Event> {
	List<Event> getByEventName(String eventName);

	List<Event> getByEventDate(Date eventDate);

	List<Event> getByPersonId(int personId);
}
