package com.example.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.learning.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
