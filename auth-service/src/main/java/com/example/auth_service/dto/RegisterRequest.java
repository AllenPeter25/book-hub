package com.example.auth_service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message = "required")
    private String username;

    @NotBlank(message = "required")
    private String password;
}
