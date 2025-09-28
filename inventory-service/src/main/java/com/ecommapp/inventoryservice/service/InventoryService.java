package com.ecommapp.inventoryservice.service;

import com.ecommapp.inventoryservice.model.InventoryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InventoryService implements IInventoryService {

    private static final Logger log = LoggerFactory.getLogger(InventoryService.class);

    public InventoryResponse createInventory(String productId, String productName, Integer quantity) {
        // Generate a random inventory ID (in a real application, this would be saved to a database)
        String inventoryId = UUID.randomUUID().toString();
        
        // Return the response with the generated inventory ID
        return new InventoryResponse(inventoryId);
    }
}