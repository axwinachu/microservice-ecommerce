package com.example.user_service.facade;

import com.example.user_service.dto.LoginDto;
import com.example.user_service.dto.SignUpDto;
import com.example.user_service.mapper.Mapper;
import com.example.user_service.model.User;
import com.example.user_service.response.AuthResponse;
import com.example.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthFacade {
    private final UserService userService;
    private final Mapper mapper;
    public AuthResponse signup(SignUpDto signUpDto) {
        if(userService.existedByEmail(signUpDto.getEmail())) {
            return new AuthResponse("400", "user already existed");
        }
        userService.save(mapper.DtoTOEntity(signUpDto));
        return new AuthResponse("200","registered successfully");
    }

    public AuthResponse login(LoginDto loginDto) {
        if(userService.existedByEmail(loginDto.getEmail())){
            //matcher adding finally
            User originalUser=userService.findUserByEmail(loginDto.getEmail());
            if(originalUser.getPassword().equals(loginDto.getPassword())){
                return new AuthResponse("200","token some time working on feature later");
            }
        }
        return new AuthResponse("400","invalid password");
    }
}
