package com.tts.rsvrinClass.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.rsvrinClass.model.User;
import com.tts.rsvrinClass.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserServiceInt{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	@Override
	public User findUserById(Long id) {
		return userRepository.findUserById(id);
		//we don't like findById because it returns an optional; 
		//so we create our own in the Repository and call it findUserById
		//remember this is based on the very specific naming convention and gets converted into SQL based on what we name  this
		//and so we are overriding the default behavior that we usually get from findById
		//and our id is required since it is primary key
	}
	
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public User updateUserById(Long id, User userFromForm) {
		User userFromDb = findUserById(id);
		
//			userFromDb.setName(userFromForm.getName());
//			userFromDb.setEmail(userFromForm.getEmail());	
		
        BeanUtils.copyProperties(userFromForm, userFromDb); // Make sure to check
      
        return userRepository.save(userFromDb);

	
	//we are working with 2 users here
	//we're getting user information from form and we're getting user from DB
	//we wanna grab what we get from form and we want to overlay it onto DB
	//before we did this statically/manually
	//Springboot  
	}
	
	@Override
	public void deleteUserById(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

}
