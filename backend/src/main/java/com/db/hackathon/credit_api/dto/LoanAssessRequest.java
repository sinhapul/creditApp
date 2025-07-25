package com.db.hackathon.credit_api.dto;

import java.math.BigDecimal;

public record LoanAssessRequest (
    String userId,
    BigDecimal requestAmount
) {}
