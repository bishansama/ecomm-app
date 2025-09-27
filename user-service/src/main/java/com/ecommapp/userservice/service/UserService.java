package com.ecommapp.userservice.service;

import com.ecommapp.userservice.model.UserRequest;
import com.ecommapp.userservice.model.UserResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    public UserResponse createUser(UserRequest userRequest) {
        // Generate a random user ID (in a real application, this would be saved to a database)
        String userId = UUID.randomUUID().toString();
        UserResponse response = new UserResponse();
        response.setUserId(userId);
        return response;
    }
}