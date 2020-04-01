package com.nagp.microservices.aggregator.entities;

import java.util.Set;

public class OrderDetails {

	private User userDetails;
	
	private Set<Order> orders;

	public OrderDetails(User userDetails, Set<Order> orders) {
		this.userDetails = userDetails;
		this.orders = orders;
	}

	public User getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	
	
}
