package com.test.organizer.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.TemporalType;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.Type;
import org.springframework.stereotype.Repository;

import com.test.organizer.dao.EventDao;
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
		// TODO Rewrite without Criteria
		Criteria criteria = getSession().createCriteria(getEntityClass().getCanonicalName());
		criteria.add(Restrictions.eqProperty("eventName", eventName));
		return (List<Event>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> getByEventDate(Date eventDate) {
		// TODO Rewrite without Criteria
		Criteria criteria = getSession().createCriteria(getEntityClass().getCanonicalName());
		criteria.add(Restrictions.eq("eventDate", eventDate));
		return (List<Event>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> getByUsername(String username) {
		return (List<Event>) getSession().createQuery("from Event where username = ?").setParameter(0, username).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> getEventBetweenTwoDates(Date startDate, Date endDate) {
		System.out.println(startDate);
		System.out.println(endDate);
		return (List<Event>) getSession().createQuery("from Event where eventDate between ? and ?").setDate(0, startDate).setDate(1, endDate).list();

//		Criteria criteria = getSession().createCriteria(getEntityClass().getCanonicalName());
//		criteria.add(Restrictions.between("eventDate", startDate, endDate));
//		return (List<Event>) criteria.list();
	}
}
