package com.tts.rsvrinClass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tts.rsvrinClass.model.User;
import com.tts.rsvrinClass.service.UserServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	
	//Get all users
	@GetMapping()
	public List<User> getUsers(){
		return userServiceImpl.findAll();
	}
	
	//Get User by id
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		return userServiceImpl.findUserById(id);
		
	}
	
	//Create a user
	@PostMapping()	//this will post to our root users, so we don't need to specify a path here
	public User saveUser(User user) {
		return userServiceImpl.saveUser(user);

	}
	
	//Update user
	@PutMapping("/{id}") //put for updates
	public User updateUser(@PathVariable Long id, User user) {
		return userServiceImpl.updateUserById(id, user);		
	}

	//Delete a user
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		userServiceImpl.deleteUserById(id);
	}

}
