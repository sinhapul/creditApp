package com.db.hackhathon.service;// package com.db.hackathon.credit_api.service;

// import java.math.BigDecimal;
// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.db.hackathon.credit_api.client.OpenAIClient;
// import com.db.hackathon.credit_api.dto.LoanAssessRequest;
// import com.db.hackathon.credit_api.dto.LoanAssessResponse;
// import com.db.hackathon.credit_api.entity.Transaction;
// import com.db.hackathon.credit_api.repository.TransactionRepository;

// import lombok.RequiredArgsConstructor;

// @Service
// @RequiredArgsConstructor
// public class CreditScoringService {
    
//     private final TransactionRepository transactionRepository;
//     private final OpenAIClient openAIClient;

//     public LoanAssessResponse assessLoan(LoanAssessRequest req) {

//         int score = calculateScore(req.getUserId());

//         BigDecimal eligible = BigDecimal.valueOf(score * 100);
//         BigDecimal rate = score > 750 
//             ? BigDecimal.valueOf(10.5) 
//             : BigDecimal.valueOf(15.0);
        
//         String freq = score > 650 ? "weekly" : "daily";

//         return new LoanAssessResponse(score, eligible, rate, freq);
//     }

//     private int calculateScore(Long userId) {
        
//         List<Transaction> transactions = transactionRepository.findByUserId(userId);
//         int score = 600;
//         for (Transaction transaction : transactions) {
//             String label = openAIClient.classify(transaction.getDescription());
//             score += transaction.getAmount().intValue() / 100;
//         }

//         return Math.min(score, 900);
//     }
// }
