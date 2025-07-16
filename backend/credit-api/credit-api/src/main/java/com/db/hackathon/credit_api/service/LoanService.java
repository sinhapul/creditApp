package com.db.hackathon.credit_api.service;

import com.db.hackathon.credit_api.dto.*;
import com.db.hackathon.credit_api.entity.Loan;
import com.db.hackathon.credit_api.entity.User;
import com.db.hackathon.credit_api.repository.LoanRepository;
import com.db.hackathon.credit_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LoanService {
    private final LoanRepository loanRepository;
    private final UserRepository userRepository;

    @Transactional
    public LoanInitializeResponse initializeLoan(LoanInitializeRequest req) {
        User user = userRepository.findById(req.userId())
            .orElseThrow(() -> new IllegalArgumentException("User not found"));

        // Recompute interest rate (or trust the one passed)
        var score = req.creditScore().intValue();
        var interestRate = determineRate(score);

        Loan loan = new Loan();
        loan.setUser(user);
        loan.setPrincipalAmount(req.loanAmount());
        loan.setInterestRate(interestRate);
        loan.setRepaymentFrequency(req.preferredFrequency());
        loan.setStartDate(LocalDateTime.now());
        loan.setEndDate(LocalDateTime.now().plusDays(30));  // 30-day demo
        loan.setStatus(Loan.LoanStatus.ACTIVE);

        Loan saved = loanRepository.save(loan);
        return new LoanInitializeResponse(saved.getId(), saved.getStatus().name());
    }

    public LoanStatusResponse getLoanStatus(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
            .orElseThrow(() -> new IllegalArgumentException("Loan not found"));
        return new LoanStatusResponse(
            loan.getId(),
            loan.getStatus().name(),
            loan.getPrincipalAmount(),
            loan.getRepaymentFrequency()
        );
    }

    @Transactional
    public PaymentScheduleResponse schedulePayment(PaymentScheduleRequest req) {
        Loan loan = loanRepository.findById(req.loanId())
            .orElseThrow(() -> new IllegalArgumentException("Loan not found"));
        loan.setRepaymentFrequency(req.newFrequency());
        loanRepository.save(loan);
        return new PaymentScheduleResponse(loan.getId(), loan.getRepaymentFrequency());
    }

    @Transactional
    public LoanAdjustResponse adjustLoan(Long loanId, LoanAdjustRequest req) {
        Loan loan = loanRepository.findById(loanId)
            .orElseThrow(() -> new IllegalArgumentException("Loan not found"));
        loan.setInterestRate(req.newInterestRate());
        loanRepository.save(loan);
        return new LoanAdjustResponse(loan.getId(), loan.getInterestRate());
    }

    // Helper to pick rate by score
    private static java.math.BigDecimal determineRate(int score) {
        if (score >= 750)       return java.math.BigDecimal.valueOf(10.5);
        if (score >= 700)       return java.math.BigDecimal.valueOf(12.5);
        if (score >= 650)       return java.math.BigDecimal.valueOf(15.0);
        if (score >= 600)       return java.math.BigDecimal.valueOf(18.0);
        return java.math.BigDecimal.ZERO;
    }
}
