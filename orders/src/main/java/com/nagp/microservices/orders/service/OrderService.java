package com.nagp.microservices.orders.service;

import java.util.Set;

import com.nagp.microservices.orders.entities.Order;

public interface OrderService {

	Set<Order> getOrderDetails(Integer userId);

}
