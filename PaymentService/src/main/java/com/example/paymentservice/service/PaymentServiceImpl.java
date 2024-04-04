package com.example.paymentservice.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.paymentservice.entity.TransactionDetails;
import com.example.paymentservice.model.PaymentRequest;
import com.example.paymentservice.repository.TransactionDetailsRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	TransactionDetailsRepository transactionDetailsRepository;
	
	@Override
	public long doPayment(PaymentRequest paymentRequest) {
		
		log.info("Recording paymnet Details :: "+paymentRequest);
		
		TransactionDetails transactionDetails = TransactionDetails.builder()
				.paymentDate(new Date()).amount(paymentRequest.getAmount())
				.paymentMode(paymentRequest.getPaymentMode()+"").paymentStatus("SUCCESS")
				.orderId(paymentRequest.getOrderId())
				.build(); 
		transactionDetails = transactionDetailsRepository.save(transactionDetails);
		log.info("Transaction Completed for Id :: "+transactionDetails.getId());
		return transactionDetails.getId();
	}

}
