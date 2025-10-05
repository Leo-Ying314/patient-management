package io.github.leoying314.auth_service.service.impl;

import io.github.leoying314.auth_service.model.User;
import io.github.leoying314.auth_service.repository.UserRepository;
import io.github.leoying314.auth_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
