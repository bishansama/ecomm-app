package com.ecommapp.userservice.service;

import com.ecommapp.userservice.model.UserRequest;
import com.ecommapp.userservice.model.UserResponse;

/**
 * Interface for User Service operations.
 * Defines the contract for user management functionality.
 */
public interface IUserService {
    
    /**
     * Creates a new user in the system.
     * 
     * @param userRequest the user details
     * @return UserResponse containing user ID and status
     */
    UserResponse createUser(UserRequest userRequest);
}