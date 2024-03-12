package com.example.learning.orderservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.learning.orderservice.external.response.ErrorResponse;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	
	@ExceptionHandler(OrderServiceCustomException.class)
	public ResponseEntity<ErrorResponse> handlerProductServiceException(OrderServiceCustomException exception){
		
		new ErrorResponse();
		return new ResponseEntity<>(
				ErrorResponse
				.builder()
				.errorMessage(exception.getMessage())
				.code(exception.getErrorCode())
				.build()
				,HttpStatus.NOT_FOUND
				);
	}
}
