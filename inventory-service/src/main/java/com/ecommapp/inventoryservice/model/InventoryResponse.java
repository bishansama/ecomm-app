package com.ecommapp.inventoryservice.model;

public class InventoryResponse {
    private String inventoryId;

    public InventoryResponse() {
    }

    public InventoryResponse(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }
}