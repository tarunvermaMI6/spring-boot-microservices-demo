package com.example.learning.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.learning.orderservice.model.OrderRequest;
import com.example.learning.orderservice.service.OrderService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping("/place-order")
	public ResponseEntity<Long> placeOrder(@RequestBody OrderRequest orderRequest){
		
		long orderId = this.orderService.placeOrder(orderRequest);
		log.info("Order Id :"+orderId);
		return new ResponseEntity<Long>(orderId,HttpStatus.OK);
	}
}
