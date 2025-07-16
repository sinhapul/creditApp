package com.db.hackathon.credit_api.dto;

import java.math.BigDecimal;

public record LoanAdjustResponse (
    Long loanId,
    BigDecimal interestRate
) {}
