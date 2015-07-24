package com.test.organizer.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.organizer.dao.UserDao;
import com.test.organizer.entity.UserRole;
 
@Service("userDetailsService")
public class MyUserDetailService implements UserDetailsService {
 
	//get user from the database, via Hibernate
	@Autowired
	private UserDao userDao;
 
	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(final String username) 
		throws UsernameNotFoundException {
 
		com.test.organizer.entity.User user = userDao.findByUserName(username);
		System.out.println("123" + user.getUsername());
		List<GrantedAuthority> authorities = 
                                      buildUserAuthority(user.getUserRole());
		System.out.println("1" + user.getUserRole());
 
		return buildUserForAuthentication(user, authorities);
 
	}
 
	// Converts com.test.organizer.entity.User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(com.test.organizer.entity.User user, 
		List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), 
				user.isEnabled(), true, true, true, authorities);
	}
 
	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
 
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
 
		// Build user's authorities
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
			System.out.println(userRole.getRole());
		}
 
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
 
		return Result;
	}
 
}