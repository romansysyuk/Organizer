package com.test.organizer.todo;

import java.util.Date;

public class Event {
	private int eventId;
	private Date eventDate;
	private String eventName;
	private int personId;
	private int clasterId;
	private String description;

	public Event() {

	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public int getGroupId() {
		return clasterId;
	}

	public void setGroupId(int groupId) {
		this.clasterId = groupId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
