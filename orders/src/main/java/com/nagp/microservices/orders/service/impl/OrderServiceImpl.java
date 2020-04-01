package com.nagp.microservices.orders.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.nagp.microservices.orders.entities.Order;
import com.nagp.microservices.orders.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Override
	public Set<Order> getOrderDetails(Integer userId) {
		List<Order> allOrders = getAllOrders();
		Set<Order> orderPerUser = new HashSet<>();
		for(Order order : allOrders) {
			if(order.getUserId() == userId) {
				orderPerUser.add(order);
			}
		}
		
		if(orderPerUser.isEmpty()) {
			orderPerUser.add(new Order(0, 0, 0.0, "No order for this user Id"));
		}
		
		return orderPerUser;
	}

	private List<Order> getAllOrders() {
		
		List<Order> allOrders = new ArrayList<>();
		
		allOrders.add(new Order(1, 1, 250.0, "15-Apr-2020"));
		allOrders.add(new Order(1, 2, 350.0, "19-Apr-2020"));
		allOrders.add(new Order(2, 1, 300.0, "25-Mar-2020"));
		allOrders.add(new Order(2, 2, 210.0, "20-Apr-2020"));
		allOrders.add(new Order(2, 3, 150.0, "15-Jan-2020"));
		allOrders.add(new Order(3, 1, 290.0, "07-Apr-2020"));
		allOrders.add(new Order(3, 2, 120.0, "09-Jun-2020"));
		allOrders.add(new Order(4, 1, 980.0, "15-Oct-2020"));
		allOrders.add(new Order(5, 1, 320.0, "19-Apr-2020"));
		allOrders.add(new Order(5, 2, 730.0, "25-Dec-2020"));
		
		return allOrders;
	}

}
