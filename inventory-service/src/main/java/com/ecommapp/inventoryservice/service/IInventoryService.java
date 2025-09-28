package com.ecommapp.inventoryservice.service;

import com.ecommapp.inventoryservice.model.InventoryResponse;

/**
 * Interface for Inventory Service operations.
 * Defines the contract for inventory management functionality.
 */
public interface IInventoryService {
    
    /**
     * Creates a new inventory entry for a product.
     * 
     * @param productId the unique identifier of the product
     * @param productName the name of the product
     * @param quantity the initial quantity in stock
     * @return InventoryResponse containing inventory ID and status
     */
    InventoryResponse createInventory(String productId, String productName, Integer quantity);
}