package com.ecommapp.orderservice.service;

import com.ecommapp.orderservice.model.OrderRequest;
import com.ecommapp.orderservice.model.OrderResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    public OrderResponse createOrder(OrderRequest orderRequest) {
        // Generate a random order ID (in a real application, this would be saved to a database)
        String orderId = UUID.randomUUID().toString();
        OrderResponse response = new OrderResponse();
        response.setOrderId(orderId);
        return response;
    }
}