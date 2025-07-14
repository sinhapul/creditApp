package com.db.hackhathon.dto;

import java.math.BigDecimal;

public record LoanAssessResponse( 
    int creditScore,
    BigDecimal eligibleAmount,
    BigDecimal interestRate,
    String setRepaymentFrequency
) {}
