package com.db.hackhathon.dto;

import java.math.BigDecimal;

public record LoanAdjustResponse (
    Long loanId,
    BigDecimal interestRate
) {}
