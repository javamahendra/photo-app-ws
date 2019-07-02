package com.app.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.app.controller.UserRequestModel;
import com.app.response.UserResponseModel;

public interface UserService extends UserDetailsService{

	UserResponseModel createUser(UserRequestModel userModel);
	
	UserResponseModel getUser(String email);
}
