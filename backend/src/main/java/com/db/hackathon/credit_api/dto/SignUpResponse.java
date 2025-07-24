package com.db.hackathon.credit_api.dto;

public record SignUpResponse(
    boolean success,
    String message
) {}