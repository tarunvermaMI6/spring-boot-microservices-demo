package com.example.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.paymentservice.entity.TransactionDetails;

@Repository
public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, Long> {

}
