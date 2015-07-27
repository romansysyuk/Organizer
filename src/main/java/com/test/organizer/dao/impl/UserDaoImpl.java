package com.test.organizer.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.test.organizer.dao.UserDao;
import com.test.organizer.entity.User;

@Repository
public class UserDaoImpl extends AbstractDaoImpl<User>implements UserDao {

	public User findByUserName(String username) {
		return (User) getSession().createQuery("from User where username=?").setParameter(0, username).uniqueResult();

	}

	@Override
	public User getById(int id) {
		return (User) getSession().createQuery("from User where user_id=?");
	}

	@Override
	@Transactional
	public void save(User entity) {
		getSession().save(entity);
	}

	@Override
	public void update(User entity) {
		getSession().update(entity);
	}

	@Override
	public void delete(User entity) {
		getSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		return (List<User>) getSession().createQuery("from User").list();
	}

	@Override
	public Class<User> getEntityClass() {
		return User.class;
	}
}
