package com.ecommapp.fulfillmentservice.controller;

import com.ecommapp.fulfillmentservice.model.*;
import com.ecommapp.fulfillmentservice.service.IFulfillmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/fulfillment")
@Tag(name = "Fulfillment", description = "Order fulfillment operations")
public class FulfillmentController {

    private static final Logger log = LoggerFactory.getLogger(FulfillmentController.class);
    private final IFulfillmentService fulfillmentService;

    public FulfillmentController(IFulfillmentService fulfillmentService) {
        this.fulfillmentService = fulfillmentService;
    }

    @PostMapping("/validate-order")
    @Operation(summary = "Validate Order", description = "Validates order details including product existence, stock availability, and shipping address")
    public ResponseEntity<OrderValidationResponse> validateOrder(@Valid @RequestBody OrderValidationRequest request) {
        log.info("Received order validation request for order: {}", request.getOrderId());
        
        OrderValidationResponse response = fulfillmentService.validateOrder(request);
        
        if (response.isValid()) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/initiate-delivery")
    @Operation(summary = "Initiate Delivery", description = "Initiates delivery process by assigning warehouse, delivery method, shipping carrier, and tracking ID")
    public ResponseEntity<DeliveryInitiationResponse> initiateDelivery(@Valid @RequestBody DeliveryInitiationRequest request) {
        log.info("Received delivery initiation request for order: {}", request.getOrderId());
        
        DeliveryInitiationResponse response = fulfillmentService.initiateDelivery(request);
        
        return ResponseEntity.ok(response);
    }

    @PostMapping("/capture-payment")
    @Operation(summary = "Capture Payment", description = "Captures payment if not captured at order creation")
    public ResponseEntity<PaymentCaptureResponse> capturePayment(@Valid @RequestBody PaymentCaptureRequest request) {
        log.info("Received payment capture request for order: {}", request.getOrderId());
        
        PaymentCaptureResponse response = fulfillmentService.capturePayment(request);
        
        if ("CAPTURED".equals(response.getStatus())) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/generate-shipping-label")
    @Operation(summary = "Generate Shipping Label", description = "Generates shipping label for the order")
    public ResponseEntity<ShippingLabelResponse> generateShippingLabel(@Valid @RequestBody ShippingLabelRequest request) {
        log.info("Received shipping label generation request for order: {}", request.getOrderId());
        
        ShippingLabelResponse response = fulfillmentService.generateShippingLabel(request);
        
        return ResponseEntity.ok(response);
    }

    @GetMapping("/health")
    @Operation(summary = "Health Check", description = "Health check endpoint for the fulfillment service")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Fulfillment Service is healthy");
    }
}