package com.nagp.microservices.user.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagp.microservices.user.entities.User;
import com.nagp.microservices.user.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Resource
	UserService userService;
	
	@GetMapping
	public String getUserDetails(@RequestParam(name = "id") Integer id){
		User user = userService.getUserDetails(id);
		
		String userJSONString = null;
		
			userJSONString = "{\"name\":\""+ user.getName() + "\",\"email\":\""+ user.getEmail() + "\"}";
		
		return userJSONString;
	}

}
