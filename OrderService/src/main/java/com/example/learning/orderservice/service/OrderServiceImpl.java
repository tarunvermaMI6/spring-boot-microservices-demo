package com.example.learning.orderservice.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.learning.orderservice.entity.Order;
import com.example.learning.orderservice.external.client.PaymentService;
import com.example.learning.orderservice.external.client.ProductService;
import com.example.learning.orderservice.external.request.PaymentRequest;
import com.example.learning.orderservice.model.OrderRequest;
import com.example.learning.orderservice.repostitory.OrderRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	@Autowired
	ProductService productService;
	@Autowired
	PaymentService paymentService;

	@Autowired
	RestTemplate restTemplate;
	
	public long placeOrder(OrderRequest orderRequest) {

		// Order Entity -> Save the data with Status Order Created
		// Product Service - Block Products (Reduce the Quantity)
		// Payment Service -> Payments -> Success-> COMPLETE, Else
		// CANCELLED
		log.info("placing order :: " + orderRequest);

		productService.reduceQuantity(orderRequest.getProductId(), orderRequest.getQauntity());

		Order order = Order.builder().amount(orderRequest.getTotalAmount()).orderDate(Instant.now())
				.orderStatus("CREATED").quantity(orderRequest.getQauntity()).productId(orderRequest.getProductId())
				.build();

		order = this.orderRepository.save(order);
		log.info("Order Placed with order id :: " + order.getId());

		log.info("callling payment service .......");

		PaymentRequest paymentRequest = PaymentRequest.builder().orderId(order.getId())
				.amount(orderRequest.getTotalAmount()).paymentMode(orderRequest.getPaymentMode()).build();

		String orderStatus = "";
		try {
			
		//	paymentService.doPayment(paymentRequest); // using feign client
			
			restTemplate.postForEntity("http://PAYMENT-SERVICE/payment", paymentRequest,ResponseEntity.class);
			
			orderStatus = "SUCCESS";
			
		} catch (Exception ex) {
			log.info("Error Occurred while doing payment");
			orderStatus = "FAILED";
			ex.printStackTrace();
		}
		order.setOrderStatus(orderStatus);
		orderRepository.save(order);
		
		return order.getId();
	}
}
