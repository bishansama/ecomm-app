package com.ecommapp.userservice.model;

public class UserResponse {
    private String userId;

    // Default constructor
    public UserResponse() {
    }

    // All args constructor
    public UserResponse(String userId) {
        this.userId = userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getUserId() {
        return userId;
    }
}