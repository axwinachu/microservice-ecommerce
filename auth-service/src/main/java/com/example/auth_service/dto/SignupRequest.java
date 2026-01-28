package com.example.auth_service.dto;

import lombok.Data;

@Data
public class SignupRequest {
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
}
