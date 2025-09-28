package com.ecommapp.fulfillmentservice.model;

import java.time.LocalDateTime;

public class ShippingLabelResponse {
    
    private String orderId;
    private String trackingId;
    private String labelId;
    private String labelUrl;
    private byte[] labelData;
    private String format; // PDF, PNG, etc.
    private LocalDateTime generatedAt;
    private String status;
    private String message;
    
    public ShippingLabelResponse() {}
    
    public ShippingLabelResponse(String orderId, String trackingId, String labelId, String labelUrl, 
                                byte[] labelData, String format, LocalDateTime generatedAt, String status, String message) {
        this.orderId = orderId;
        this.trackingId = trackingId;
        this.labelId = labelId;
        this.labelUrl = labelUrl;
        this.labelData = labelData;
        this.format = format;
        this.generatedAt = generatedAt;
        this.status = status;
        this.message = message;
    }
    
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    
    public String getTrackingId() { return trackingId; }
    public void setTrackingId(String trackingId) { this.trackingId = trackingId; }
    
    public String getLabelId() { return labelId; }
    public void setLabelId(String labelId) { this.labelId = labelId; }
    
    public String getLabelUrl() { return labelUrl; }
    public void setLabelUrl(String labelUrl) { this.labelUrl = labelUrl; }
    
    public byte[] getLabelData() { return labelData; }
    public void setLabelData(byte[] labelData) { this.labelData = labelData; }
    
    public String getFormat() { return format; }
    public void setFormat(String format) { this.format = format; }
    
    public LocalDateTime getGeneratedAt() { return generatedAt; }
    public void setGeneratedAt(LocalDateTime generatedAt) { this.generatedAt = generatedAt; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}