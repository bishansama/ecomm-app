package com.ecommapp.fulfillmentservice.service;

import com.ecommapp.fulfillmentservice.model.*;

/**
 * Interface for Fulfillment Service operations.
 * Defines the contract for order fulfillment functionality.
 */
public interface IFulfillmentService {
    
    /**
     * Validates an order before processing.
     * 
     * @param request the order validation request containing order details
     * @return OrderValidationResponse containing validation results
     */
    OrderValidationResponse validateOrder(OrderValidationRequest request);
    
    /**
     * Initiates delivery process for an order.
     * 
     * @param request the delivery initiation request containing order and shipping details
     * @return DeliveryInitiationResponse containing delivery tracking information
     */
    DeliveryInitiationResponse initiateDelivery(DeliveryInitiationRequest request);
    
    /**
     * Captures payment for an order.
     * 
     * @param request the payment capture request containing payment details
     * @return PaymentCaptureResponse containing payment capture results
     */
    PaymentCaptureResponse capturePayment(PaymentCaptureRequest request);
    
    /**
     * Generates shipping label for an order.
     * 
     * @param request the shipping label request containing order and shipping details
     * @return ShippingLabelResponse containing generated label information
     */
    ShippingLabelResponse generateShippingLabel(ShippingLabelRequest request);
}