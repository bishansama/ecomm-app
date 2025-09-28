package com.ecommapp.orderservice.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Map;

public class OrderRequest {
    @NotBlank(message = "Order details cannot be empty")
    private String orderDetails;
    
    @NotEmpty(message = "Order items cannot be empty")
    private List<Map<String, Object>> items;
    
    @NotNull(message = "Shipping address is required")
    private Map<String, String> shippingAddress;
    
    private String preferredDeliveryMethod;

    public OrderRequest() {}

    public OrderRequest(String orderDetails, List<Map<String, Object>> items, Map<String, String> shippingAddress, String preferredDeliveryMethod) {
        this.orderDetails = orderDetails;
        this.items = items;
        this.shippingAddress = shippingAddress;
        this.preferredDeliveryMethod = preferredDeliveryMethod;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public List<Map<String, Object>> getItems() {
        return items;
    }

    public void setItems(List<Map<String, Object>> items) {
        this.items = items;
    }

    public Map<String, String> getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Map<String, String> shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getPreferredDeliveryMethod() {
        return preferredDeliveryMethod;
    }

    public void setPreferredDeliveryMethod(String preferredDeliveryMethod) {
        this.preferredDeliveryMethod = preferredDeliveryMethod;
    }
}