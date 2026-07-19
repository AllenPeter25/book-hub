package com.example.auth_service.dto;

import com.example.auth_service.enums.Role;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class RegisterResponse {

    private UUID id;
    private String username;
    private String password;
    private Role role;
}
