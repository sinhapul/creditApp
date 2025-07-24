package com.db.hackathon.credit_api.service;

import com.db.hackathon.credit_api.dto.SignInRequest;
import com.db.hackathon.credit_api.dto.SignInResponse;
import com.db.hackathon.credit_api.dto.SignUpRequest;
import com.db.hackathon.credit_api.dto.SignUpResponse;
import com.db.hackathon.credit_api.entity.User;
import com.db.hackathon.credit_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public SignUpResponse signUp(SignUpRequest request) {

        if (userRepository.findByPhoneNumber(request.phoneNumber()).isPresent()) {
            return new SignUpResponse(false, "Phone number already registered.");
        }

        if (userRepository.findByUserId(request.userId()).isPresent()) {
            return new SignUpResponse(false, "User ID already exists.");
        }

        // You should hash the password in production!
        User user = new User();
        user.setUserId(request.userId());
        user.setPhoneNumber(request.phoneNumber());
        user.setPassword(request.password());
        userRepository.save(user);

        return new SignUpResponse(true, "Sign-up successful!");
    }

    public SignInResponse signIn(SignInRequest request) {
        // Find user by userId
        User user = userRepository.findByUserId(request.userId()).orElse(null);

        if (user == null) {
            return new SignInResponse(false, "User ID does not exist.");
        }

        // In production, compare hashed password!
        if (!user.getPassword().equals(request.password())) {
            return new SignInResponse(false, "Invalid password.");
        }

        return new SignInResponse(true, "Login successful!");
    }
}

