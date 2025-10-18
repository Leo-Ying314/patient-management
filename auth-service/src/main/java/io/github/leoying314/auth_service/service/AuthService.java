package io.github.leoying314.auth_service.service;

import io.github.leoying314.auth_service.dto.LoginRequestDTO;

import java.util.Optional;

public interface AuthService {
    public Optional<String> authenticate(LoginRequestDTO loginRequestDTO);
    public boolean validateToken(String token);
}
