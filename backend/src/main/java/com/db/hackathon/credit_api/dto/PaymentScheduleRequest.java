package com.db.hackathon.credit_api.dto;

public record PaymentScheduleRequest (
    Long loanId,
    String newFrequency,
    String adjustmentReason
) {}
