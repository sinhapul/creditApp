// src/main/java/com/db/hackathon/creditapi/service/CreditScoringService.java
package com.db.hackathon.credit_api.service;

import com.db.hackathon.credit_api.client.OpenAIClient;
import com.db.hackathon.credit_api.dto.LoanAssessRequest;
import com.db.hackathon.credit_api.dto.LoanAssessResponse;
import com.db.hackathon.credit_api.entity.Transaction;
import com.db.hackathon.credit_api.entity.User;
import com.db.hackathon.credit_api.repository.TransactionRepository;
import com.db.hackathon.credit_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreditScoringService {
    private final UserRepository userRepo;
    private final TransactionRepository txnRepo;
    private final OpenAIClient openAIClient;

    public LoanAssessResponse assessLoan(LoanAssessRequest req) {
        // 1) load user
        User user = userRepo.findById(req.userId())
            .orElseThrow(() -> new IllegalArgumentException("User not found"));

        // 2) fetch last‑N transactions (assumes repo method exists)
        List<Transaction> txns = txnRepo
            .findByUserIdOrderByPaymentDateDesc(user.getId())
            .stream()
            .limit(10)
            .collect(Collectors.toList());

        // 3) ask the LLM for a credit score
        int score = openAIClient.getCreditScore(user, txns);

        // 4) compute eligible amount
        BigDecimal eligible = req.requestAmount()
            .min(BigDecimal.valueOf(score).multiply(BigDecimal.valueOf(100)));

        // 5) pick interest rate & frequency
        BigDecimal rate = determineRate(score);
        String freq   = determineFrequency(score);

        return new LoanAssessResponse(score, eligible, rate, freq);
    }

    private static BigDecimal determineRate(int score) {
        if (score >= 750)      return BigDecimal.valueOf(10.5);
        if (score >= 700)      return BigDecimal.valueOf(12.5);
        if (score >= 650)      return BigDecimal.valueOf(15.0);
        if (score >= 600)      return BigDecimal.valueOf(18.0);
        return BigDecimal.ZERO;
    }

    private static String determineFrequency(int score) {
        if (score < 600)            return "Not Eligible";
        else if (score < 650)       return "weekly (restricted)";
        else if (score < 700)       return "weekly";
        else                         return "daily,weekly";
    }
}
