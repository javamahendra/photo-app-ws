package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.response.UserResponseModel;
import com.app.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userSrevice;
	
	@PostMapping
	public UserResponseModel createUser(@RequestBody UserRequestModel userModel) {
		
		
		return userSrevice.createUser(userModel);
	}
}
