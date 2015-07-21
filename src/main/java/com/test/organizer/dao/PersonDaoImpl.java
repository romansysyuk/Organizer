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

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Person> findByName(String personName1, String personName2) {
//		return entityManager.createNamedQuery(Person.FIND_BY_TWO_NAMES).setParameter(1, personName1)
//				.setParameter(2, personName2).getResultList();
//	}

}
