package com.example.learning.orderservice.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.learning.orderservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
