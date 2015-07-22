//package com.test.organizer.configuration;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// 
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
// 
//	@Autowired
//	DataSource dataSource;
// 
//	@Autowired
//	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
// 
//	  auth.jdbcAuthentication().dataSource(dataSource)
//		.usersByUsernameQuery(
//			"select login, password from person where login=?")
//		.authoritiesByUsernameQuery(
//			"select login, roleName from personrole where login=?");
//	}	
// 
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
// 
//	  http.authorizeRequests()
//		.antMatchers("/home/**").access("hasRole('ROLE_ADMIN')")
//		.and()
//		  .formLogin().loginPage("/login").failureUrl("/login?error")
//		  .usernameParameter("login").passwordParameter("password")
//		.and()
//		  .logout().logoutSuccessUrl("/login?logout")
//		.and()
//		  .exceptionHandling().accessDeniedPage("/403")
//		.and()
//		  .csrf();
//	}
//}