package com.test.organizer.service;

import java.util.List;

import com.test.organizer.entity.Person;

public interface PersonService{
	public List<Person> getPersonByName(String personName);
	public List<Person> getPersonByTwoNames(String personName1, String personName2);
	public boolean savePerson(Person person);
	public boolean updatePerson(Person person);
	public boolean deletePerson(Person person);
}
