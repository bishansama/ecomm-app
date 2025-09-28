package com.ecommapp.fulfillmentservice.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

public class DeliveryInitiationRequest {
    
    @NotBlank(message = "Order ID is required")
    private String orderId;
    
    @NotNull(message = "Shipping address is required")
    private OrderValidationRequest.ShippingAddress shippingAddress;
    
    private String preferredDeliveryMethod; // STANDARD, EXPRESS, OVERNIGHT
    private String specialInstructions;
    
    public DeliveryInitiationRequest() {}
    
    public DeliveryInitiationRequest(String orderId, OrderValidationRequest.ShippingAddress shippingAddress, 
                                   String preferredDeliveryMethod, String specialInstructions) {
        this.orderId = orderId;
        this.shippingAddress = shippingAddress;
        this.preferredDeliveryMethod = preferredDeliveryMethod;
        this.specialInstructions = specialInstructions;
    }
    
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    
    public OrderValidationRequest.ShippingAddress getShippingAddress() { return shippingAddress; }
    public void setShippingAddress(OrderValidationRequest.ShippingAddress shippingAddress) { this.shippingAddress = shippingAddress; }
    
    public String getPreferredDeliveryMethod() { return preferredDeliveryMethod; }
    public void setPreferredDeliveryMethod(String preferredDeliveryMethod) { this.preferredDeliveryMethod = preferredDeliveryMethod; }
    
    public String getSpecialInstructions() { return specialInstructions; }
    public void setSpecialInstructions(String specialInstructions) { this.specialInstructions = specialInstructions; }
}