package com.example.user_service.controller;

import com.example.user_service.dto.LoginDto;
import com.example.user_service.dto.SignUpDto;
import com.example.user_service.facade.AuthFacade;
import com.example.user_service.response.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthFacade authFacade;
    @PostMapping("/signup")
    public AuthResponse signup(@RequestBody SignUpDto signUpDto){
        return authFacade.signup(signUpDto);
    }
    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginDto loginDto){
        return authFacade.login(loginDto);
    }
}
