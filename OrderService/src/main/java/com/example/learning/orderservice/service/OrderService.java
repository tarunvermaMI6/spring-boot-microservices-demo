package com.example.learning.orderservice.service;

import com.example.learning.orderservice.model.OrderRequest;

public interface OrderService {

	 long placeOrder(OrderRequest orderRequest);
}
