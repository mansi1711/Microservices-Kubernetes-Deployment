package com.nagp.microservices.orders.controller;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagp.microservices.orders.entities.Order;
import com.nagp.microservices.orders.service.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
	
	@Resource
	OrderService orderService;
	
	@GetMapping
	public Set<Order> getOrderDetails(@RequestParam(name = "userId") Integer userId){
		
		return orderService.getOrderDetails(userId);
		
	}

}
