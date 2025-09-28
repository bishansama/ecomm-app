package com.ecommapp.inventoryservice.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class InventoryRequest {
    
    @NotBlank(message = "Product ID is required")
    private String productId;
    
    @NotBlank(message = "Product name is required")
    private String productName;
    
    @Positive(message = "Quantity must be positive")
    private Integer quantity;

    public InventoryRequest() {
    }

    public InventoryRequest(String productId, String productName, Integer quantity) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}