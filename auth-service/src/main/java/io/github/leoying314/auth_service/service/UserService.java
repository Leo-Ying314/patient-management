package io.github.leoying314.auth_service.service;

import io.github.leoying314.auth_service.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByEmail(String email);
}
