package com.test.organizer.dao;

import com.test.organizer.entity.User;

public interface UserDao extends AbstractDao<User>{
	User findByUserName(String username);
}
