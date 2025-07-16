package com.db.hackathon.credit_api.dto;

import java.math.BigDecimal;

public record LoanAssessRequest (
    Long userId,
    String paymentAppId,
    BigDecimal requestAmount,
    BigDecimal existingObligations
) {}
