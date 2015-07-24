package com.test.organizer.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.test.organizer.dao.AbstractDao;

public abstract class AbstractDaoImpl<E> implements AbstractDao<E> {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public E getById(int id) {
		return (E) getSession().get(getEntityClass(), id);
	}

	@Override
	public void save(E entity) {
		getSession().persist(entity);
	}

	@Override
	public void update(E entity) {
		getSession().update(entity);
	}

	@Override
	public void delete(E entity) {
		getSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> getAll() {
		return (List<E>) getSession().createQuery("from User" ).list();
				//createCriteria(getEntityClass().getCanonicalName()).list();
	}

}
