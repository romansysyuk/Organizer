package com.test.organizer.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.test.organizer.entity.Event;

@Repository("eventDaoImpl")
public class EventDaoImpl extends AbstractDaoImpl<Event>implements EventDao {

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> getByEventDate(Date eventDate) {
		Criteria criteria = getSession().createCriteria(getEntityClass().getCanonicalName());
		criteria.add(Restrictions.eq("eventDate", eventDate));
		return (List<Event>) criteria.list();
	}
}
