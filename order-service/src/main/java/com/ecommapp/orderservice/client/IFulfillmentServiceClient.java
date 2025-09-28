package com.ecommapp.orderservice.client;

import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * Interface for Fulfillment Service Client operations.
 * Defines the contract for external fulfillment service interactions.
 */
public interface IFulfillmentServiceClient {
    
    /**
     * Validates an order with the fulfillment service.
     * 
     * @param orderData the order data to validate
     * @return Mono containing validation response
     */
    Mono<Map<String, Object>> validateOrder(Map<String, Object> orderData);
    
    /**
     * Initiates delivery for an order through the fulfillment service.
     * 
     * @param orderId the order ID
     * @param deliveryData the delivery data
     * @return Mono containing delivery response
     */
    Mono<Map<String, Object>> initiateDelivery(String orderId, Map<String, Object> deliveryData);
}