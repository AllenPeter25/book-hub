package com.example.auth_service.repository;

import com.example.auth_service.entity.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthRepository extends JpaRepository<UserAuth, UUID> {
    boolean existsByUsername(String username);
    UserAuth findByUsername(String username);
}
