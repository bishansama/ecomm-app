package com.ecommapp.shoppingcartservice.model;

import java.util.List;

public class CartResponse {
    
    private String userId;
    private List<CartItem> items;
    private Double totalAmount;
    private String message;
    
    public CartResponse() {}
    
    public CartResponse(String userId, List<CartItem> items, Double totalAmount, String message) {
        this.userId = userId;
        this.items = items;
        this.totalAmount = totalAmount;
        this.message = message;
    }
    
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    
    public List<CartItem> getItems() { return items; }
    public void setItems(List<CartItem> items) { this.items = items; }
    
    public Double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }
    
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}