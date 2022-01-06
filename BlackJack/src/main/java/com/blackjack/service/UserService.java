package com.blackjack.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackjack.entity.user.User;
import com.blackjack.entity.user.UserRespository;

@Service
public class UserService {
	
	private Logger log = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserRespository userRespository;
	
	public User createUser(User user) {
		log.info("Created a new user : {}", user);
		User newUser =  userRespository.save(user);	
		return newUser;
	}
	public User getUser(String username, String password) {
		return userRespository.getUser(username, password);
	}
	

}
