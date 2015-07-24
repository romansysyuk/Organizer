package com.test.organizer.service;

import com.test.organizer.entity.User;

public interface UserService {
	User findById(int id);

	User findByUserName(String username);

	boolean saveUser(User user);

	boolean updateUser(User user);

	boolean deleteUser(User user);
}
