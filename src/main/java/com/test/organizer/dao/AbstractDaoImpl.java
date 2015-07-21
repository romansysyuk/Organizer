package com.test.organizer.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDaoImpl<E> implements AbstractDao<E> {

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession(){
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
	public void remove(E entity) {
		getSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> getAll() {
		return (List<E>) getSession().createCriteria(getEntityClass().getCanonicalName()).list();
	}

}
