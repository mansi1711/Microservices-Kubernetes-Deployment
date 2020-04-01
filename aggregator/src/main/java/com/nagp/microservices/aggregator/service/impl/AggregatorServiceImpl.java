package com.nagp.microservices.aggregator.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagp.microservices.aggregator.entities.Order;
import com.nagp.microservices.aggregator.entities.OrderDetails;
import com.nagp.microservices.aggregator.entities.User;
import com.nagp.microservices.aggregator.service.AggregatorService;

@Service
public class AggregatorServiceImpl implements AggregatorService{
	
	Logger logger = LoggerFactory.getLogger(AggregatorServiceImpl.class);
	
	@Autowired
	Environment env;
	
	@Resource
	private RestTemplate restTemplate;

	@Override
	public OrderDetails getOrderDetails(Integer userId) {
		
		logger.info("AggregatorServiceImpl", "Inside method getOrderDetails");
		
		return new OrderDetails(getUserDetails(userId), getOrderPerUser(userId));

	}

	private Set<Order> getOrderPerUser(Integer userId) {
		
		logger.info("Inside method getOrderPerUser");
		
		String baseUrl = env.getProperty("BASE_URL_ORDERS")+"/orders";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Set> response = null;

		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseUrl).queryParam("userId", userId);
			response = restTemplate.exchange(builder.buildAndExpand().toUri(), HttpMethod.GET, null, Set.class);
		} catch (Exception ex) {
			logger.info(ex.getMessage()+"");
		}
		Set<Order> orderDetails = (Set<Order>)response.getBody();
		return orderDetails;
	}

	private User getUserDetails(Integer userId) {
		
		logger.info("Inside method getUserDetails");
		
		String baseUrl = env.getProperty("BASE_URL_USER")+"/user";
		System.out.println(baseUrl);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = null;

		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseUrl).queryParam("id", userId);
			response = restTemplate.exchange(builder.buildAndExpand().toUri(), HttpMethod.GET, null, String.class);
		} catch (Exception ex) {
			logger.info(""+ex.getMessage());
		}
		String userJSONString = response.getBody();
		User user = null;
		try {
			user = new ObjectMapper().readValue(userJSONString, User.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	

}
