package com.example.learning.orderservice.external.decoder;

import java.io.IOException;

import com.example.learning.orderservice.exception.OrderServiceCustomException;
import com.example.learning.orderservice.external.response.ErrorResponse;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.log4j.Log4j2;

// to decode the error we are getting while calling external apis
@Log4j2
public class CustomErrorDecoder implements ErrorDecoder{

	@Override
	public Exception decode(String methodKey, Response response) {
		
		ObjectMapper mapper = new ObjectMapper();
		log.info("request url :: "+response.request().url());
		log.info("request header :: "+response.request().headers());
		
		try {
			ErrorResponse errorResponse = mapper.readValue(response.body().asInputStream(),ErrorResponse.class);
			return new OrderServiceCustomException(errorResponse.getErrorMessage(),errorResponse.getCode());
		} catch (StreamReadException e) {
			e.printStackTrace();
			return new OrderServiceCustomException("INTERNAL SERVER ERROR", "500");
		} catch (DatabindException e) {
			e.printStackTrace();
			return new OrderServiceCustomException("INTERNAL SERVER ERROR", "500");
		} catch (IOException e) {
			e.printStackTrace();
			return new OrderServiceCustomException("INTERNAL SERVER ERROR", "500");
		}
	}

	
}
