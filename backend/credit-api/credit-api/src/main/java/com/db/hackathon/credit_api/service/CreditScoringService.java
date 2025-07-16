// package com.db.hackathon.credit_api.service;

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

//         int score = calculateScore(req.userId());

//         // Determine eligible amount
//         BigDecimal eligible = req.requestAmount()
//             .min(BigDecimal.valueOf(score).multiply(BigDecimal.valueOf(100)));

//         // Pick interest rate tier
//         BigDecimal rate;
//         if (score >= 750)       rate = BigDecimal.valueOf(10.5);
//         else if (score >= 700)  rate = BigDecimal.valueOf(12.5);
//         else if (score >= 650)  rate = BigDecimal.valueOf(15.0);
//         else if (score >= 600)  rate = BigDecimal.valueOf(18.0);
//         else                    rate = BigDecimal.ZERO;  // not eligible

//         // Offer frequency options
//         String freq;
//         if (score < 600)            freq = "Not Eligible";
//         else if (score < 650)       freq = "weekly (restricted)";
//         else if (score < 700)       freq = "weekly";
//         else                        freq = "daily,weekly";

//         return new LoanAssessResponse(score, eligible, rate, freq);
//     }

//     private int calculateScore(Long userId) {
        
//         List<Transaction> txns = transactionRepository.findByUserId(userId);
//         int base = 600;

//         for (Transaction txn : txns) {

//             String label = openAIClient.classify();

//             switch (label) {
//                 case "high_risk":
//                     base -= 50;
//                     break;
            
//                 default:
//                     break;
//             }
//             base += transaction.getAmount().compareTo(BigDecimal.ZERO) > 0 ? 10 : -5;
//         }

    

//         // Example scoring logic based on transaction history
//         int score = 0;
//         for (Transaction transaction : transactions) {
//             if (transaction.getAmount().compareTo(BigDecimal.ZERO) > 0) {
//                 score += 10; // Positive transactions increase score
//             } else {
//                 score -= 5; // Negative transactions decrease score
//             }
//         }

//         // Use OpenAI to refine the score based on additional data
//         return openAIClient.refineScore(score);
//     }
// }
