package com.test.organizer.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "birthday")
	private Date birthday;

	@Column(name = "email")
	private String email;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "password")
	private String password;

	public Person() {

	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName1() {
		return firstName;
	}

	public void setPersonName1(String personName1) {
		this.firstName = personName1;
	}

	public String getPersonName2() {
		return lastName;
	}

	public void setPersonName2(String personName2) {
		this.lastName = personName2;
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
}
