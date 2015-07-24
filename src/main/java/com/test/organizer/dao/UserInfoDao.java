package com.test.organizer.dao;

import java.util.List;

import com.test.organizer.entity.UserInfo;

public interface UserInfoDao extends AbstractDao<UserInfo> {
	List<UserInfo> findByName(String firstName);

	List<UserInfo> findByTwoNames(String firstName, String lastName);
	
	UserInfo findByUserName(String userName);
}