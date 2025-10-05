package io.github.leoying314.auth_service.service.impl;

import io.github.leoying314.auth_service.dto.LoginRequestDTO;
import io.github.leoying314.auth_service.model.User;
import io.github.leoying314.auth_service.repository.UserRepository;
import io.github.leoying314.auth_service.service.AuthService;
import io.github.leoying314.auth_service.service.UserService;
import io.github.leoying314.auth_service.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public Optional<String> authenticate(LoginRequestDTO loginRequestDTO) {
        Optional<String> token = userService
                .findByEmail(loginRequestDTO.email())
                .filter(u -> passwordEncoder.matches(loginRequestDTO.password(),
                        u.getPassword()))
                .map(u -> jwtUtil.generateToken(u.getEmail(), u.getRole()));

        return token;
    }
}
