package com.db.hackathon.credit_api.dto;

public record SignUpRequest(
    String userId,
    String phoneNumber,
    String password
) {}
