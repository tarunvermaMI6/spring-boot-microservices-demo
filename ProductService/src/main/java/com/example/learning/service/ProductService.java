package com.example.learning.service;

import com.example.learning.model.ProductRequest;
import com.example.learning.model.ProductResponse;

public interface ProductService {

	long addProduct(ProductRequest productRequest);
	ProductResponse getProductById(long iD);
	void reduceQuantity(long productId, long qunatity);
}
