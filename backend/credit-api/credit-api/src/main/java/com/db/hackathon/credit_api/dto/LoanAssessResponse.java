package com.db.hackathon.credit_api.dto;

import java.math.BigDecimal;

public record LoanAssessResponse( 
    int creditScore,
    BigDecimal eligibleAmount,
    BigDecimal interestRate,
    String repaymentFrequency
) {}
