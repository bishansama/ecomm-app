package com.ecommapp.orderservice.service;

import com.ecommapp.orderservice.model.OrderRequest;
import com.ecommapp.orderservice.model.OrderResponse;

/**
 * Interface for Order Service operations.
 * Defines the contract for order management functionality.
 */
public interface IOrderService {
    
    /**
     * Creates a new order and initiates the fulfillment process.
     * 
     * @param orderRequest the order details
     * @return OrderResponse containing order ID and status
     */
    OrderResponse createOrder(OrderRequest orderRequest);
}