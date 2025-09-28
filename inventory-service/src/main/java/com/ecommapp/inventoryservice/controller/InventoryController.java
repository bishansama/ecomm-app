package com.ecommapp.inventoryservice.controller;

import com.ecommapp.inventoryservice.model.InventoryRequest;
import com.ecommapp.inventoryservice.model.InventoryResponse;
import com.ecommapp.inventoryservice.service.IInventoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final IInventoryService inventoryService;

    public InventoryController(IInventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InventoryResponse createInventory(@Valid @RequestBody InventoryRequest request) {
        return inventoryService.createInventory(
                request.getProductId(),
                request.getProductName(),
                request.getQuantity()
        );
    }
}