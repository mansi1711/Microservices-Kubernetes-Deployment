package com.nagp.microservices.aggregator.entities;

public class Order {
	
	private Integer userId;
	
	private Integer orderId;
	
	private Double orderAmount;
	
	private String orderDate;

	public Order(Integer userId, Integer orderId, Double orderAmount, String orderDate) {
		this.userId = userId;
		this.orderId = orderId;
		this.orderAmount = orderAmount;
		this.orderDate = orderDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	

}
