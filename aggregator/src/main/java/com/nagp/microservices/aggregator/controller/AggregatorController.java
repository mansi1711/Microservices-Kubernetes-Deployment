package com.nagp.microservices.aggregator.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagp.microservices.aggregator.entities.OrderDetails;
import com.nagp.microservices.aggregator.service.AggregatorService;

@RestController
@RequestMapping(value = "/orderdetails")
public class AggregatorController {
	
	Logger logger = LoggerFactory.getLogger(AggregatorController.class);
	
	@Resource
	AggregatorService aggregatorService;
	
	@GetMapping(value = "/{userId}")
	public OrderDetails getOrderDetails(@PathVariable(name = "userId") String userId) {
		Integer userid = Integer.parseInt(userId);
		logger.info("Inside method getOrderDetails and userId is " + userId);
		return aggregatorService.getOrderDetails(userid);
		
	}

}
