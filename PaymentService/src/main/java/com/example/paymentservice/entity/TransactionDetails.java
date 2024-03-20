package com.example.paymentservice.entity;

import org.hibernate.annotations.Generated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transaction_details")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDetails {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long orderId;
	private String paymentMode;
	private String refrenceNumber;
	private String paymentDate;
	private String paymentStatus;
	private long amount;
	
}
