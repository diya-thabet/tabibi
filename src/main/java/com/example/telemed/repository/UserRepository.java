package com.example.telemed.repository;

import com.example.telemed.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Optional: Add custom query methods if needed, e.g., findByEmail
    User findByEmail(String email);
}