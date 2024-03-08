package com.example.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.learning.model.ProductRequest;
import com.example.learning.model.ProductResponse;
import com.example.learning.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/add")
	public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest) {

		long productId = productService.addProduct(productRequest);
		return new ResponseEntity<>(productId, HttpStatus.CREATED);

	}
	
	@GetMapping("/get/{iD}")
	public ResponseEntity<ProductResponse> getProductById(@PathVariable("iD") long iD){
		
		ProductResponse productResponse = productService.getProductById(iD);
		return new ResponseEntity<>(productResponse,HttpStatus.OK);
		
	}
	
	@PutMapping("/reduceQuantity/{id}")
	public ResponseEntity<Void> reduceQuantity(@PathVariable("id") long productId, @RequestParam long quantity) {
	
		productService.reduceQuantity(productId,quantity);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
