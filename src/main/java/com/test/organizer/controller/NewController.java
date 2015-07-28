package com.test.organizer.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.organizer.entity.UserInfo;

@Controller
@RequestMapping(value = "/editUser.add/htm")
public class NewController {
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody UserInfo add(HttpServletRequest request, HttpServletResponse response) throws Exception {

		UserInfo userInfo = new UserInfo();

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String birthday = request.getParameter("birthday");

		userInfo.setEmail(email);
		userInfo.setFirstName(firstName);
		userInfo.setLastName(lastName);
		userInfo.setBirthday(new Date());

		return userInfo;
	}
}
