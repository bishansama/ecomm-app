package com.ecommapp.fulfillmentservice.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentCaptureResponse {
    
    private String orderId;
    private String paymentId;
    private String transactionId;
    private BigDecimal capturedAmount;
    private String currency;
    private String status;
    private LocalDateTime capturedAt;
    private String message;
    
    public PaymentCaptureResponse() {}
    
    public PaymentCaptureResponse(String orderId, String paymentId, String transactionId, 
                                 BigDecimal capturedAmount, String currency, String status, 
                                 LocalDateTime capturedAt, String message) {
        this.orderId = orderId;
        this.paymentId = paymentId;
        this.transactionId = transactionId;
        this.capturedAmount = capturedAmount;
        this.currency = currency;
        this.status = status;
        this.capturedAt = capturedAt;
        this.message = message;
    }
    
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    
    public String getPaymentId() { return paymentId; }
    public void setPaymentId(String paymentId) { this.paymentId = paymentId; }
    
    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
    
    public BigDecimal getCapturedAmount() { return capturedAmount; }
    public void setCapturedAmount(BigDecimal capturedAmount) { this.capturedAmount = capturedAmount; }
    
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public LocalDateTime getCapturedAt() { return capturedAt; }
    public void setCapturedAt(LocalDateTime capturedAt) { this.capturedAt = capturedAt; }
    
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}