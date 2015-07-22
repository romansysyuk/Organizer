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
	public Person getById(int id) {
		Person person = personDao.getById(id);
		return person;
	}

	@Override
	public List<Person> getAllPersons() {
		List<Person> allPersons = personDao.getAll();
		return allPersons;
	}

	@Override
	public List<Person> getPersonByName(String personName) {
		List<Person> persons = (List<Person>) personDao.findByName(personName);
		return persons;
	}

	@Override
	public List<Person> getPersonByTwoNames(String firstName, String lastName) {
		List<Person> persons = (List<Person>) personDao.findByTwoNames(firstName, lastName);
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
		personDao.delete(person);
		return false;
	}
}
