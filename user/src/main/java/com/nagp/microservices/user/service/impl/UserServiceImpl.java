package com.nagp.microservices.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nagp.microservices.user.entities.User;
import com.nagp.microservices.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Override
	public User getUserDetails(Integer id) {
		List<User> users = getAllUsers();
		
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		
		return new User(0, "User not found", 0, "empty");
		
	}

	private List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		users.add(new User(1, "Mansi", 24, "mns.sharma17@gmail.com"));
		users.add(new User(2, "Abhishek", 27, "abhishek@gmail.com"));
		users.add(new User(3, "Babita", 49, "babita@gmail.com"));
		users.add(new User(4, "Sunil", 53, "sunil@gmail.com"));
		users.add(new User(5, "Himanshu", 24, "himanshu@gmail.com"));
		
		return users;
	}

}
