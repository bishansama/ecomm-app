package com.ecommapp.orderservice.model;

public class OrderResponse {
    private String orderId;
    private String status;
    private String trackingId;
    private String estimatedDeliveryDate;
    private String message;

    public OrderResponse() {}

    public OrderResponse(String orderId, String status, String trackingId, String estimatedDeliveryDate, String message) {
        this.orderId = orderId;
        this.status = status;
        this.trackingId = trackingId;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
        this.message = message;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public String getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(String estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}