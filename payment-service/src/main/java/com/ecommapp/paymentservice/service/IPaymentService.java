package com.ecommapp.paymentservice.service;

import com.ecommapp.paymentservice.model.PaymentRequest;
import com.ecommapp.paymentservice.model.PaymentResponse;

/**
 * Interface for Payment Service operations.
 * Defines the contract for payment processing functionality.
 */
public interface IPaymentService {
    
    /**
     * Processes a payment request using the specified payment method.
     * 
     * @param request the payment details including amount, method, and user info
     * @return PaymentResponse containing payment status and transaction details
     */
    PaymentResponse processPayment(PaymentRequest request);
}