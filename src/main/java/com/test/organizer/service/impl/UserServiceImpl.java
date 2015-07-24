package com.test.organizer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.organizer.dao.UserDao;
import com.test.organizer.entity.User;
import com.test.organizer.service.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User findById(int id) {
		return userDao.getById(id);
	}

	@Override
	public boolean saveUser(User user) {
		userDao.save(user);
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		userDao.update(user);
		return true;
	}

	@Override
	public boolean deleteUser(User user) {
		userDao.delete(user);
		return true;
	}

	@Override
	public User findByUserName(String username) {
		return userDao.findByUserName(username);
	}

}
