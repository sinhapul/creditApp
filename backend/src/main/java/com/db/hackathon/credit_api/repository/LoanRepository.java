package com.db.hackathon.credit_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.hackathon.credit_api.entity.Loan;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByUserId(Long userId);
}
