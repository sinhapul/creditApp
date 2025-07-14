package com.db.hackhathon.dto;

public record PaymentScheduleRequest (
    Long loanId,
    String newFrequency,
    String adjustmentReason
) {}
