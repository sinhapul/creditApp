package com.db.hackhathon.dto;

import java.math.BigDecimal;


public record LoanInitializeRequest (
    Long userId,
    String paymentAppId,
    BigDecimal loanAmount,
    String preferredFrequency,
    BigDecimal creditScore,
    BankDetails bankDetails
) {}
