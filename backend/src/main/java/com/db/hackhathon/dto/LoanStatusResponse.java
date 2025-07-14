package com.db.hackhathon.dto;

import java.math.BigDecimal;

public record LoanStatusResponse(
    Long loanId,
    String status,
    BigDecimal principalAmount,
    String repaymentFrequency
) {}
