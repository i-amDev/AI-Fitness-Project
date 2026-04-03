package com.fitness.user_service.services;

import com.fitness.user_service.dto.RegisterRequest;
import com.fitness.user_service.dto.UserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserResponse register(RegisterRequest registerRequest);

    UserResponse getUserProfile(String userId);

    Boolean existsByUserId(String userId);
}
