package com.app.service.impl;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.controller.UserRequestModel;
import com.app.entity.UserEntity;
import com.app.repository.UserRepository;
import com.app.response.UserResponseModel;
import com.app.service.UserService;
import com.app.utils.Utils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private Utils utils;
	
	@Override
	public UserResponseModel createUser(UserRequestModel userModel) {

		if(userRepository.findByEmail(userModel.getEmail()) !=null) throw new RuntimeException(userModel.getEmail()+" Email already Exists ");
		
		UserEntity user=new UserEntity();
		
		BeanUtils.copyProperties(userModel, user);
		user.setUserId(utils.generateUserId(32));
		user.setEncryptedPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
		
		UserEntity reurnValue=userRepository.save(user);
		
		UserResponseModel userResponseModel=new UserResponseModel();
		
		BeanUtils.copyProperties(reurnValue, userResponseModel);
		
		return userResponseModel;
	}
	
	@Override
	public UserResponseModel getUser(String email) {
		
		UserEntity userEntity=userRepository.findByEmail(email);
		
		if(userEntity ==null) throw new UsernameNotFoundException(email);
		
		UserResponseModel userModel=new UserResponseModel();
		
		BeanUtils.copyProperties(userEntity, userModel);
		
		return userModel;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		UserEntity userEntity= userRepository.findByEmail(email);
		
		if(userEntity ==null) throw new UsernameNotFoundException(email);
	
		return new User(userEntity.getEmail(),userEntity.getEncryptedPassword(),new ArrayList<>());
	}

}
