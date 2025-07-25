package com.db.hackathon.credit_api.dto;

public record CreditScoreRequest(
    String userId,
    int age,
    String gender,
    String location,
    Integer electricityBill,
    Integer waterBill
) {}
