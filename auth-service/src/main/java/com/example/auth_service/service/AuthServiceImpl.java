package com.example.auth_service.service;

import com.example.auth_service.dto.LoginRequest;
import com.example.auth_service.dto.LoginResponse;
import com.example.auth_service.dto.RegisterRequest;
import com.example.auth_service.entity.UserAuth;
import com.example.auth_service.enums.Role;
import com.example.auth_service.errorHandler.UserExists;
import com.example.auth_service.repository.AuthRepository;
import com.example.auth_service.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Override
    public void createUserAuth(RegisterRequest request) {
        if (repository.existsByUsername(request.getUsername())) {
            throw new UserExists(request.getUsername() + " already exists");
        }

        UserAuth user = UserAuth.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        repository.save(user);
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        UserAuth user = repository.findByUsername(request.getUsername());

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtService.generateToken(user.getUsername());

        return new LoginResponse(token);

    }
}
