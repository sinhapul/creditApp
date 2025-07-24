package com.db.hackathon.credit_api.dto;

public record SignInRequest(
    String userId,
    String password
) {}
