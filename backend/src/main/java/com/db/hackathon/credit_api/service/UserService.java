package com.db.hackathon.credit_api.service;

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
}

