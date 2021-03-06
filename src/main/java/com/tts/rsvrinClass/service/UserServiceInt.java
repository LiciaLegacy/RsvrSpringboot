package com.tts.rsvrinClass.service;

import java.util.List;

import com.tts.rsvrinClass.model.User;

public interface UserServiceInt {

	List<User> findAll();
	
	User findUserById(Long id);
	
	User saveUser(User user);
	
	User updateUserById(Long id, User user);
	
	void deleteUserById(Long id);
	
	
}
