package com.test.organizer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.organizer.dao.UserInfoDao;
import com.test.organizer.entity.UserInfo;
import com.test.organizer.service.UserInfoService;

@Service("userInfoService")
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;

	@Override
	public UserInfo getById(int id) {
		UserInfo person = userInfoDao.getById(id);
		return person;
	}

	@Override
	public List<UserInfo> getAllPersons() {
		List<UserInfo> allPersons = userInfoDao.getAll();
		return allPersons;
	}

	@Override
	public List<UserInfo> getPersonByName(String personName) {
		List<UserInfo> persons = (List<UserInfo>) userInfoDao.findByName(personName);
		return persons;
	}

	@Override
	public List<UserInfo> getPersonByTwoNames(String firstName, String lastName) {
		List<UserInfo> persons = (List<UserInfo>) userInfoDao.findByTwoNames(firstName, lastName);
		return persons;
	}

	@Override
	public boolean savePerson(UserInfo person) {
		userInfoDao.save(person);
		return true;
	}

	@Override
	public boolean updatePerson(UserInfo person) {
		userInfoDao.update(person);
		return true;
	}

	@Override
	public boolean deletePerson(UserInfo person) {
		userInfoDao.delete(person);
		return false;
	}
}
