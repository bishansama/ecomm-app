package com.ecommapp.fulfillmentservice.model;

import java.time.LocalDateTime;

public class DeliveryInitiationResponse {
    
    private String orderId;
    private String trackingId;
    private String warehouseLocation;
    private String deliveryMethod;
    private String shippingCarrier;
    private LocalDateTime estimatedDeliveryDate;
    private String status;
    private String message;
    
    public DeliveryInitiationResponse() {}
    
    public DeliveryInitiationResponse(String orderId, String trackingId, String warehouseLocation, 
                                    String deliveryMethod, String shippingCarrier, 
                                    LocalDateTime estimatedDeliveryDate, String status, String message) {
        this.orderId = orderId;
        this.trackingId = trackingId;
        this.warehouseLocation = warehouseLocation;
        this.deliveryMethod = deliveryMethod;
        this.shippingCarrier = shippingCarrier;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
        this.status = status;
        this.message = message;
    }
    
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    
    public String getTrackingId() { return trackingId; }
    public void setTrackingId(String trackingId) { this.trackingId = trackingId; }
    
    public String getWarehouseLocation() { return warehouseLocation; }
    public void setWarehouseLocation(String warehouseLocation) { this.warehouseLocation = warehouseLocation; }
    
    public String getDeliveryMethod() { return deliveryMethod; }
    public void setDeliveryMethod(String deliveryMethod) { this.deliveryMethod = deliveryMethod; }
    
    public String getShippingCarrier() { return shippingCarrier; }
    public void setShippingCarrier(String shippingCarrier) { this.shippingCarrier = shippingCarrier; }
    
    public LocalDateTime getEstimatedDeliveryDate() { return estimatedDeliveryDate; }
    public void setEstimatedDeliveryDate(LocalDateTime estimatedDeliveryDate) { this.estimatedDeliveryDate = estimatedDeliveryDate; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}