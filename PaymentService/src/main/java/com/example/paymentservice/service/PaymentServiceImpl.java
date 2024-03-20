package com.example.paymentservice.service;

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
		
		TransactionDetails transactionDetails = TransactionDetails.builder().build(); 
		
		return 0;
	}

}
