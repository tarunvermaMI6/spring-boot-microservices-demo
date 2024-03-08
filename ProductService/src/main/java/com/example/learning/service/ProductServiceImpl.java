package com.example.learning.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.learning.entity.Product;
import com.example.learning.exception.ProductServiceCustomException;
import com.example.learning.model.ProductRequest;
import com.example.learning.model.ProductResponse;
import com.example.learning.repository.ProductRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public long addProduct(ProductRequest productRequest) {

		log.info(":: adding product ....");

		Product product = Product.builder()
				.productName(productRequest.getName())
				.price(productRequest.getPrice())
				.quantity(productRequest.getQuantity())
				.build();

		productRepository.save(product);

		log.info(":: product created...");
		return product.getProductId();
	}

	@Override
	public ProductResponse getProductById(long iD) {
		
		log.info("Getting product with given Id :: "+iD);
		Product product = productRepository.findById(iD)
				          .orElseThrow(
				        	() -> new ProductServiceCustomException("Product with given Id doesn't exist","PRODUCT_NOT_FOUND"));
		
		ProductResponse productResponse = new ProductResponse(); 
		BeanUtils.copyProperties(product, productResponse);
		
		return productResponse;
	}

	@Override
	public void reduceQuantity(long productId, long qunatity) {
		
		log.info("Reduce Quantity for Id : "+ productId );
		
		Product product = productRepository.findById(productId)
				.orElseThrow(
						() -> new ProductServiceCustomException("Product with given Id doesn't exist","PRODUCT_NOT_FOUND"));
		
		if(product.getQuantity() < qunatity) {
			throw new ProductServiceCustomException("Product does not have suffecient Quantity", "INSUFFICIENT_QUANTITY");
		}
		
		product.setQuantity(product.getQuantity()-qunatity);
		productRepository.save(product);
		
		log.info("Product Quantity Updated Successfully for Id "+ productId);
	}
}
