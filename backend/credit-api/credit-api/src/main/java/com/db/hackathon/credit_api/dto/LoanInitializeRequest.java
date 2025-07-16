package com.db.hackathon.credit_api.dto;

import java.math.BigDecimal;


public record LoanInitializeRequest (
    Long userId,
    String paymentAppId,
    BigDecimal loanAmount,
    String preferredFrequency,
    BigDecimal creditScore,
    BankDetails bankDetails
) {}
