package com.example.learning.orderservice.external.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

	private long productId;
	private String productName;
	private String price;
	private long quantity;
}

