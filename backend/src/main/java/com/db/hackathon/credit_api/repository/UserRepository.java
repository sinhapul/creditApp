package com.db.hackathon.credit_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.hackathon.credit_api.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByUserId(String userId);
    Optional<User> findByPhoneNumber(String phoneNumber);


}
