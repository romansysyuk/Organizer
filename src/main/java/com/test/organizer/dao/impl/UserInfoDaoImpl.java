package com.test.organizer.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.test.organizer.dao.UserInfoDao;
import com.test.organizer.entity.UserInfo;

@Repository("userInfoDaoImpl")
public class UserInfoDaoImpl extends AbstractDaoImpl<UserInfo>implements UserInfoDao {

	@Override
	public Class<UserInfo> getEntityClass() {

		return UserInfo.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfo> findByName(String firstName) {
		// TODO Rewrite without Criteria
		Criteria criteria = getSession().createCriteria(getEntityClass().getCanonicalName());
		criteria.add(Restrictions.eq("first_name", firstName));
		return (List<UserInfo>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfo> findByTwoNames(String firstName, String lastName) {
		// TODO Rewrite without Criteria
		Criteria criteria = getSession().createCriteria(getEntityClass().getCanonicalName());
		criteria.add(Restrictions.eq("first_name", firstName));
		criteria.add(Restrictions.eq("last_name", lastName));
		return (List<UserInfo>) criteria.list();
	}

	@Override
	public UserInfo findByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}
}
