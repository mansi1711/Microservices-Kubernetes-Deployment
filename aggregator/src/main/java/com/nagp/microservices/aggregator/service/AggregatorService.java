package com.nagp.microservices.aggregator.service;

import com.nagp.microservices.aggregator.entities.OrderDetails;

public interface AggregatorService {

	OrderDetails getOrderDetails(Integer userId);

}
