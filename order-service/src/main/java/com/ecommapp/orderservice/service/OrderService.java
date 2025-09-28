package com.ecommapp.orderservice.service;

import com.ecommapp.orderservice.client.IFulfillmentServiceClient;
import com.ecommapp.orderservice.model.OrderRequest;
import com.ecommapp.orderservice.model.OrderResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.UUID;

@Service
public class OrderService implements IOrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    private final IFulfillmentServiceClient fulfillmentServiceClient;

    @Autowired
    public OrderService(IFulfillmentServiceClient fulfillmentServiceClient) {
        this.fulfillmentServiceClient = fulfillmentServiceClient;
    }

    public OrderResponse createOrder(OrderRequest orderRequest) {
        // Generate a random order ID (in a real application, this would be saved to a database)
        String orderId = UUID.randomUUID().toString();
        
        // Create initial response
        OrderResponse response = new OrderResponse();
        response.setOrderId(orderId);
        response.setStatus("CREATED");
        response.setMessage("Order created successfully");
        
        // Create order data for validation
        Map<String, Object> orderData = Map.of(
            "orderId", orderId,
            "items", orderRequest.getItems(),
            "shippingAddress", orderRequest.getShippingAddress()
        );
        
        // Validate order with fulfillment service asynchronously
        fulfillmentServiceClient.validateOrder(orderData)
            .flatMap(validationResponse -> {
                Boolean isValid = (Boolean) validationResponse.get("isValid");
                if (Boolean.TRUE.equals(isValid)) {
                    // Create delivery data
                    Map<String, Object> deliveryData = Map.of(
                        "shippingAddress", orderRequest.getShippingAddress(),
                        "preferredDeliveryMethod", orderRequest.getPreferredDeliveryMethod() != null ? 
                            orderRequest.getPreferredDeliveryMethod() : "STANDARD"
                    );
                    return fulfillmentServiceClient.initiateDelivery(orderId, deliveryData);
                } else {
                    return Mono.just(Map.of("status", "VALIDATION_FAILED"));
                }
            })
            .subscribe(
                deliveryResponse -> {
                    String status = (String) deliveryResponse.get("status");
                    String trackingId = (String) deliveryResponse.get("trackingId");
                    String estimatedDeliveryDate = (String) deliveryResponse.get("estimatedDeliveryDate");
                    
                    // In a real application, you would update the order in the database here
                },
                error -> {
                    // In a real application, you would update the order status to failed
                }
            );
        
        return response;
    }
}