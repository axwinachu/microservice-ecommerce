package com.example.user_service.model;

import com.example.user_service.enums.Role;
import com.example.user_service.enums.Status;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false,unique = true)
    private String phoneNumber;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Role role;
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
