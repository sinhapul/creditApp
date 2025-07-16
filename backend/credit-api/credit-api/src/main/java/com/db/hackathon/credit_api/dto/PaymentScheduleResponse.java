package com.db.hackathon.credit_api.dto;

public record PaymentScheduleResponse (
    Long loanId,
    String repaymentFrequency
) {}
