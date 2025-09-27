package com.ecommapp.paymentservice.service;

import com.ecommapp.paymentservice.model.PaymentRequest;
import com.ecommapp.paymentservice.model.PaymentResponse;
import com.ecommapp.paymentservice.model.PaymentStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PaymentService {
    
    public PaymentResponse processPayment(PaymentRequest request) {
        // Generate unique payment ID
        String paymentId = UUID.randomUUID().toString();
        
        // Generate transaction ID
        String transactionId = "TXN-" + System.currentTimeMillis();
        
        // Simulate payment processing logic
        PaymentStatus status = processPaymentByMethod(request);
        
        // Create response
        return new PaymentResponse(
            paymentId,
            request.getOrderId(),
            request.getUserId(),
            request.getAmount(),
            request.getCurrency(),
            request.getPaymentMethod(),
            status,
            transactionId,
            LocalDateTime.now(),
            getStatusMessage(status)
        );
    }
    
    private PaymentStatus processPaymentByMethod(PaymentRequest request) {
        // Simulate different processing based on payment method
        switch (request.getPaymentMethod()) {
            case CREDIT_CARD:
                return processCreditCard(request);
            case DEBIT_CARD:
                return processDebitCard(request);
            case PAYPAL:
                return processPayPal(request);
            case BANK_TRANSFER:
                return processBankTransfer(request);
            case DIGITAL_WALLET:
                return processDigitalWallet(request);
            case CRYPTOCURRENCY:
                return processCryptocurrency(request);
            default:
                return PaymentStatus.FAILED;
        }
    }
    
    private PaymentStatus processCreditCard(PaymentRequest request) {
        // Simulate credit card processing
        System.out.println("Processing credit card payment for order: " + request.getOrderId());
        System.out.println("Amount: " + request.getAmount() + " " + request.getCurrency());
        
        // Simulate success/failure (90% success rate)
        return Math.random() > 0.1 ? PaymentStatus.SUCCESS : PaymentStatus.FAILED;
    }
    
    private PaymentStatus processDebitCard(PaymentRequest request) {
        // Simulate debit card processing
        System.out.println("Processing debit card payment for order: " + request.getOrderId());
        return Math.random() > 0.05 ? PaymentStatus.SUCCESS : PaymentStatus.FAILED;
    }
    
    private PaymentStatus processPayPal(PaymentRequest request) {
        // Simulate PayPal processing
        System.out.println("Processing PayPal payment for order: " + request.getOrderId());
        return Math.random() > 0.02 ? PaymentStatus.SUCCESS : PaymentStatus.FAILED;
    }
    
    private PaymentStatus processBankTransfer(PaymentRequest request) {
        // Simulate bank transfer processing
        System.out.println("Processing bank transfer for order: " + request.getOrderId());
        return PaymentStatus.PROCESSING; // Bank transfers usually take time
    }
    
    private PaymentStatus processDigitalWallet(PaymentRequest request) {
        // Simulate digital wallet processing
        System.out.println("Processing digital wallet payment for order: " + request.getOrderId());
        return Math.random() > 0.03 ? PaymentStatus.SUCCESS : PaymentStatus.FAILED;
    }
    
    private PaymentStatus processCryptocurrency(PaymentRequest request) {
        // Simulate cryptocurrency processing
        System.out.println("Processing cryptocurrency payment for order: " + request.getOrderId());
        return Math.random() > 0.15 ? PaymentStatus.SUCCESS : PaymentStatus.FAILED;
    }
    
    private String getStatusMessage(PaymentStatus status) {
        switch (status) {
            case SUCCESS:
                return "Payment processed successfully";
            case FAILED:
                return "Payment processing failed";
            case PROCESSING:
                return "Payment is being processed";
            case PENDING:
                return "Payment is pending";
            case CANCELLED:
                return "Payment was cancelled";
            case REFUNDED:
                return "Payment was refunded";
            default:
                return "Unknown payment status";
        }
    }
}