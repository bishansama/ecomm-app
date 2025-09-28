package com.ecommapp.userservice.service;

import com.ecommapp.userservice.model.UserRequest;
import com.ecommapp.userservice.model.UserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService implements IUserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    public UserResponse createUser(UserRequest userRequest) {
        // Generate a random user ID (in a real application, this would be saved to a database)
        String userId = UUID.randomUUID().toString();
        UserResponse response = new UserResponse();
        response.setUserId(userId);
        return response;
    }
}