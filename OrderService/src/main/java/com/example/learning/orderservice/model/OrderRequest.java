package com.example.learning.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {

	private long productId;
	private long totalAmount;
	private long qauntity;
	private PaymentMode paymentMode;
	
	
}
