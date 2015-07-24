package com.test.organizer.service;

import java.util.List;

import com.test.organizer.entity.UserInfo;

public interface UserInfoService {
	UserInfo getById(int id);

	List<UserInfo> getPersonByName(String personName);

	List<UserInfo> getPersonByTwoNames(String firstName, String lastName);

	List<UserInfo> getAllPersons();

	boolean savePerson(UserInfo person);

	boolean updatePerson(UserInfo person);

	boolean deletePerson(UserInfo person);
}
