package com.nagp.microservices.user.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagp.microservices.user.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Resource
	UserService userService;
	
	@GetMapping
	public String getUserDetails(@RequestParam(name = "id") Integer id){
		ObjectMapper mapper = new ObjectMapper();
		String userJSONString = null;
		try {
			userJSONString = mapper.writeValueAsString(userService.getUserDetails(id));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return userJSONString;
	}

}
