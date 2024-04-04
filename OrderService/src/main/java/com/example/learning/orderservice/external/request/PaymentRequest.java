package com.example.learning.orderservice.external.request;

import com.example.learning.orderservice.model.PaymentMode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {

	private long orderId;
	private long amount;
	private String refrenceNumber;
	private PaymentMode paymentMode;
}
