package com.nagp.microservices.user.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagp.microservices.user.entities.User;
import com.nagp.microservices.user.repository.UserRepository;
import com.nagp.microservices.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User getUserDetails(Integer id) {
			
		Optional<User> optionalUser = userRepository.findById(id);
		System.out.print("User: "+optionalUser.get().getName());
		if(optionalUser.isPresent()) {
			return optionalUser.get();
			
		}
		
		return new User(0, "User not found", 0, "empty");
		
	}

}
