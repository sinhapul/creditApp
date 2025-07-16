package com.db.hackathon.credit_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.hackathon.credit_api.entity.Transaction;


public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByUserId(Long userId);
    
    
}
