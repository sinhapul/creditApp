package com.db.hackathon.credit_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.hackathon.credit_api.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    
}
