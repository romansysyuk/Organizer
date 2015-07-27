package com.test.organizer.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user_info", uniqueConstraints = @UniqueConstraint(columnNames = { "username" }) )
public class UserInfo {

	private int userInfoId;
	private String firstName;
	private String lastName;
	private Date birthday;
	private String email;
	private User user;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_info_id", unique = true, nullable = false)
	public int getUserInfoId() {
		return userInfoId;
	}

	public void setUserInfoId(int userInfoId) {
		this.userInfoId = userInfoId;
	}

	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "birthday", nullable = false)
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "username")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserInfo(int userInfoId, String firstName, String lastName, Date birthday, String email, User user) {
		this.userInfoId = userInfoId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.email = email;
		this.user = user;
	}
	
	public UserInfo() {
	}
}
