package com.db.hackathon.credit_api.controller;

import com.db.hackathon.credit_api.dto.SignUpRequest;
import com.db.hackathon.credit_api.dto.SignUpResponse;
import com.db.hackathon.credit_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> signUp(@RequestBody SignUpRequest request) {
        SignUpResponse response = userService.signUp(request);
        if (!response.success()) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }
}

