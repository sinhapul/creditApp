// package com.db.hackathon.credit_api.service;

// import org.springframework.stereotype.Service;

// import com.db.hackathon.credit_api.dto.LoanInitializeRequest;
// import com.db.hackathon.credit_api.dto.LoanInitializeResponse;
// import com.db.hackathon.credit_api.entity.Loan;
// import com.db.hackathon.credit_api.repository.LoanRepository;
// import com.db.hackathon.credit_api.repository.UserRepository;

// import lombok.RequiredArgsConstructor;

// @Service
// @RequiredArgsConstructor
// public class LoanService {

//     private final LoanRepository loanRepository;
//     private final UserRepository userRepository;

//     public LoanInitializeResponse initializeLoan(LoanInitializeRequest req) {
        
//         User user = userRepository.findById(req.userId())
//                 .orElseThrow(() -> new IllegalArgumentException("User not found"));

//         Loan loan = new Loan();
//         loan.setUser(user);
//         loan.setPrincipalAmount(req.getLoanAmount());
//         loan.setInterestRate(req.getInterestRate());
//         loan.setRepaymentFrequency(req.getPrepaymentFrequency());

        
//     }


    
// }
