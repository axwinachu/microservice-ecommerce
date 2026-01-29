package com.example.auth_service.repository;

import com.example.auth_service.model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AuthRepository extends JpaRepository<AuthUser,Long> {
    Optional<AuthUser> findByEmail(String email);
}
