package com.example.learning.orderservice.exception;

import lombok.Data;

@Data
public class OrderServiceCustomException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;
	
	public OrderServiceCustomException(String message, String errorCode) {
	
		super(message);
		this.errorCode = errorCode;
	
	}
}
