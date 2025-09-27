package com.ecommapp.shoppingcartservice.model;

import jakarta.validation.constraints.NotBlank;

public class RemoveFromCartRequest {
    
    @NotBlank(message = "User ID is required")
    private String userId;
    
    @NotBlank(message = "Product ID is required")
    private String productId;
    
    public RemoveFromCartRequest() {}
    
    public RemoveFromCartRequest(String userId, String productId) {
        this.userId = userId;
        this.productId = productId;
    }
    
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }
}