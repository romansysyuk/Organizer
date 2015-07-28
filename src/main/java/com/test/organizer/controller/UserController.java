package com.test.organizer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.organizer.dto.RegistrationDto;
import com.test.organizer.entity.User;
import com.test.organizer.entity.UserInfo;
import com.test.organizer.service.UserInfoService;
import com.test.organizer.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserInfoService userInfoService;

	@Autowired
	UserService userService;

	@RequestMapping(value = { "/newUser" }, method = RequestMethod.GET)
	public String newPerson(ModelMap model) {
		RegistrationDto rdto = new RegistrationDto();
		model.addAttribute("rdto", rdto);
		return "newUser";
	}

	@RequestMapping(value = { "/newUser" }, method = RequestMethod.POST)
	public String savePerson(RegistrationDto rdto) {
		User user = new User(rdto.getUsername(), rdto.getPassword(), true);
		userService.saveUser(user);
		UserInfo userInfo = new UserInfo(rdto.getUserInfoId(), rdto.getFirstName(), rdto.getLastName(),
				rdto.getBirthday(), rdto.getEmail(), user);
		userInfoService.savePerson(userInfo);
		return "registrationcomleted";
	}

	@RequestMapping(value = { "/editUser" }, method = RequestMethod.GET)
	public String editUser() {
		return "editUser";
	}
}
