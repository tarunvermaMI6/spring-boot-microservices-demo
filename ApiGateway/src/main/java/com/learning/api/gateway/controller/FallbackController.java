package com.learning.api.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

	@RequestMapping("/orderservicefallback")
	public String orderServiceFallback() {
		
		return "Order service is down";
	}

	@RequestMapping("/productservicefallback")
	public String productServiceFallback() {
		
		return "Product service is down";
	}
	
	@RequestMapping("/paymentservicefallback")
	public String paymentServiceFallback() {
		
		return "Payment service is down";
	}
}
