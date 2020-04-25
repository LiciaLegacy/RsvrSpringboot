package com.tts.rsvrinClass.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tts.rsvrinClass.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findUserById(Long Id);
}
