package com.test.organizer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.organizer.dao.PersonDao;
import com.test.organizer.entity.Person;

@Service("personService")
@Transactional
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao personDao;
	
	@Override
	public List<Person> getPersonByName(String personName) {
		List<Person> persons = (List<Person>) personDao.findByName(personName);
		return persons;
	}

	@Override
	public List<Person> getPersonByTwoNames(String personName1, String personName2) {
		List<Person> persons = (List<Person>) personDao.findByTwoNames(personName1, personName2);
		return persons;
	}

	@Override
	public boolean savePerson(Person person) {
		personDao.save(person);
		return true;
	}

	@Override
	public boolean updatePerson(Person person) {
		personDao.update(person);
		return true;
	}

	@Override
	public boolean deletePerson(Person person) {
		personDao.remove(person);
		return false;
	}

}
