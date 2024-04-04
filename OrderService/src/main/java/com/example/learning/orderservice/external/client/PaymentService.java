package com.example.learning.orderservice.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.learning.orderservice.exception.OrderServiceCustomException;
import com.example.learning.orderservice.external.request.PaymentRequest;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;



@FeignClient(name ="PAYMENT-SERVICE/payment")
@CircuitBreaker(name = "external", fallbackMethod = "fallback")
public interface PaymentService {

	@PostMapping
	public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest );
	
	default void fallback(Exception ex) {
		
		throw new OrderServiceCustomException("Payment Service Not available", "500");
	}
	
}
