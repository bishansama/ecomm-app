package com.ecommapp.fulfillmentservice.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ShippingLabelRequest {
    
    @NotBlank(message = "Order ID is required")
    private String orderId;
    
    @NotBlank(message = "Tracking ID is required")
    private String trackingId;
    
    @NotNull(message = "Shipping address is required")
    private OrderValidationRequest.ShippingAddress shippingAddress;
    
    @NotNull(message = "Warehouse address is required")
    private WarehouseAddress warehouseAddress;
    
    private String deliveryMethod;
    private String shippingCarrier;
    
    public ShippingLabelRequest() {}
    
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    
    public String getTrackingId() { return trackingId; }
    public void setTrackingId(String trackingId) { this.trackingId = trackingId; }
    
    public OrderValidationRequest.ShippingAddress getShippingAddress() { return shippingAddress; }
    public void setShippingAddress(OrderValidationRequest.ShippingAddress shippingAddress) { this.shippingAddress = shippingAddress; }
    
    public WarehouseAddress getWarehouseAddress() { return warehouseAddress; }
    public void setWarehouseAddress(WarehouseAddress warehouseAddress) { this.warehouseAddress = warehouseAddress; }
    
    public String getDeliveryMethod() { return deliveryMethod; }
    public void setDeliveryMethod(String deliveryMethod) { this.deliveryMethod = deliveryMethod; }
    
    public String getShippingCarrier() { return shippingCarrier; }
    public void setShippingCarrier(String shippingCarrier) { this.shippingCarrier = shippingCarrier; }
    
    public static class WarehouseAddress {
        private String name;
        private String street;
        private String city;
        private String state;
        private String postalCode;
        private String country;
        
        public WarehouseAddress() {}
        
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        
        public String getStreet() { return street; }
        public void setStreet(String street) { this.street = street; }
        
        public String getCity() { return city; }
        public void setCity(String city) { this.city = city; }
        
        public String getState() { return state; }
        public void setState(String state) { this.state = state; }
        
        public String getPostalCode() { return postalCode; }
        public void setPostalCode(String postalCode) { this.postalCode = postalCode; }
        
        public String getCountry() { return country; }
        public void setCountry(String country) { this.country = country; }
    }
}