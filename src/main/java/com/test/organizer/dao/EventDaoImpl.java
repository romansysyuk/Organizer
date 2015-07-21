package com.test.organizer.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.test.organizer.entity.Event;

public class EventDaoImpl extends AbstractDaoImpl<Event> implements EventDao {

	@Override
	public Class<Event> getEntityClass() {
		return Event.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> getByEventName(String eventName) {
		Criteria criteria = getSession().createCriteria(getEntityClass().getCanonicalName());
		criteria.add(Restrictions.eqProperty("eventName", eventName));
		return (List<Event>) criteria.list();
	}

	@Override
	public List<Event> getByEventDate(Date eventDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> getByPersonId(int personId) {
		Criteria criteria = getSession().createCriteria(getEntityClass().getCanonicalName());
		criteria.add(Restrictions.eq("personId", personId));
		return (List<Event>) criteria.list();
	}

}
