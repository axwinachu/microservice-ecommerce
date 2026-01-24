package com.example.user_service.mapper;

import com.example.user_service.dto.SignUpDto;
import com.example.user_service.enums.Role;
import com.example.user_service.enums.Status;
import com.example.user_service.model.User;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDateTime;

@Component
public class Mapper {
    public User DtoTOEntity(SignUpDto signUpDto){
        return User.builder().name(signUpDto.getName())
                .email(signUpDto.getEmail())
                .password(signUpDto.getPassword())
                .status(Status.ACTIVE)
                .role(Role.USER)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

}
