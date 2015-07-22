package com.test.organizer.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.test.organizer.entity.Person;

@Repository("personDaoImpl")
public class PersonDaoImpl extends AbstractDaoImpl<Person>implements PersonDao {

	@Override
	public Class<Person> getEntityClass() {

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> findByName(String personName) {
		Criteria criteria = getSession().createCriteria(getEntityClass().getCanonicalName());
		criteria.add(Restrictions.eq("personName1", personName));
		return (List<Person>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> findByTwoNames(String firstName, String lastName) {
		Criteria criteria = getSession().createCriteria(getEntityClass().getCanonicalName());
		criteria.add(Restrictions.eq("personName1", firstName));
		criteria.add(Restrictions.eq("personName2", lastName));
		return (List<Person>) criteria.list();
	}
}
