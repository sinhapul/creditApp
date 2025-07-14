package com.db.hackhathon.repository;

import java.util.Optional;

import com.db.hackhathon.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByPhoneNumber(String phoneNumber);
    
}
