package com.test.organizer.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {
//	public static final String FIND_BY_NAME = "Person.findByName";
//	public static final String FIND_BY_NAME_QUERY = "SELECT p FROM person p WHERE p.personName1 = ?1 OR p.personName2 = ?1";
//	
//	public static final String FIND_BY_TWO_NAMES = "Person.findByTwoNames";
//	public static final String FIND_BY_TWO_NAMES_QUERY = "SELECT p FROM person WHERE p.personName1 = ?1 AND p.personName2 = ?2";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="personId")
	private int personId;
	
	@Column(name = "personName1")
	private String personName1;
	
	@Column(name = "personName2")
	private String personName2;
	
	@Column(name = "birthday")
	private Date birthday;

	@Column(name = "email")
	private String email;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "password")
	private String password;
	
	@OneToMany(mappedBy = "personId", fetch = FetchType.LAZY)
	private Set<Event> events;

	public Person() {

	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName1() {
		return personName1;
	}

	public void setPersonName1(String personName1) {
		this.personName1 = personName1;
	}

	public String getPersonName2() {
		return personName2;
	}

	public void setPersonName2(String personName2) {
		this.personName2 = personName2;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

}
