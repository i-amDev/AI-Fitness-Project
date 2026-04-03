package com.fitness.user_service.services.impl;

import com.fitness.user_service.dto.RegisterRequest;
import com.fitness.user_service.dto.UserResponse;
import com.fitness.user_service.models.User;
import com.fitness.user_service.repository.UserRepository;
import com.fitness.user_service.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse register(RegisterRequest registerRequest) {
        if (userRepository.existsByEmail(registerRequest.getEmail())) {
            throw new RuntimeException("Email already exists!!");
        }
        User user = User.builder()
                .firstName(registerRequest.getFirstName())
                .email(registerRequest.getEmail())
                .password(registerRequest.getPassword())
                .lastName(registerRequest.getLastName())
                .build();

        User savedUser = userRepository.save(user);

        UserResponse userResponse = UserResponse.builder()
                .firstName(savedUser.getFirstName())
                .lastName(savedUser.getLastName())
                .createdAt(savedUser.getCreatedAt())
                .updatedAt(savedUser.getUpdatedAt())
                .email(savedUser.getEmail())
                .id(savedUser.getId())
                .password(savedUser.getPassword())
                .build();

        return userResponse;
    }

    @Override
    public UserResponse getUserProfile(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User does not exists with the given Id"));

        UserResponse userResponse = UserResponse.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .email(user.getEmail())
                .id(user.getId())
                .password(user.getPassword())
                .build();

        return userResponse;
    }

    @Override
    public Boolean existsByUserId(String userId) {
        return userRepository.existsById(userId);
    }
}
