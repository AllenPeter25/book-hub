package com.example.auth_service.service;

import com.example.auth_service.dto.LoginRequest;
import com.example.auth_service.dto.LoginResponse;
import com.example.auth_service.dto.RegisterRequest;

public interface AuthService {
    void createUserAuth(RegisterRequest request);

    LoginResponse login(LoginRequest request);
}
