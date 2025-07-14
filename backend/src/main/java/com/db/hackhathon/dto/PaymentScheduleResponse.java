package com.db.hackhathon.dto;

public record PaymentScheduleResponse (
    Long loanId,
    String repaymentFrequency
) {}
