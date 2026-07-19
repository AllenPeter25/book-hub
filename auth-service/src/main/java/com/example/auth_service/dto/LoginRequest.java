package com.example.auth_service.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginRequest {
    @NotBlank(message = "required")
    private String username;

    @NotBlank(message = "required")
    private String password;
}
