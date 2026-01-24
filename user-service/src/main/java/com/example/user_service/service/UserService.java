package com.example.user_service.service;

import com.example.user_service.dto.SignUpDto;
import com.example.user_service.model.User;
import com.example.user_service.repository.UserRepository;
import com.example.user_service.response.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public boolean existedByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
