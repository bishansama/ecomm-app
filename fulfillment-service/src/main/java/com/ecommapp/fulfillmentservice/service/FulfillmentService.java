package com.ecommapp.fulfillmentservice.service;

import com.ecommapp.fulfillmentservice.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FulfillmentService implements IFulfillmentService {
    
    private static final Logger log = LoggerFactory.getLogger(FulfillmentService.class);

    public OrderValidationResponse validateOrder(OrderValidationRequest request) {
        log.info("Validating order: {}", request.getOrderId());
        
        List<OrderValidationResponse.ValidationError> errors = new ArrayList<>();
        
        // Validate product existence and stock availability
        for (OrderValidationRequest.OrderItem item : request.getItems()) {
            if (!isProductExists(item.getProductId())) {
                errors.add(new OrderValidationResponse.ValidationError(
                    "productId",
                    "Product not found: " + item.getProductId(),
                    "PRODUCT_NOT_FOUND"));
            } else if (!isStockAvailable(item.getProductId(), item.getQuantity())) {
                errors.add(new OrderValidationResponse.ValidationError(
                    "quantity",
                    "Insufficient stock for product: " + item.getProductId(),
                    "INSUFFICIENT_STOCK"));
            }
        }
        
        // Validate shipping address
        if (!isValidShippingAddress(request.getShippingAddress())) {
            errors.add(new OrderValidationResponse.ValidationError(
                "shippingAddress",
                "Invalid shipping address",
                "INVALID_ADDRESS"));
        }
        
        boolean isValid = errors.isEmpty();
        String status = isValid ? "VALID" : "INVALID";
        
        return new OrderValidationResponse(request.getOrderId(), isValid, status, errors);
    }

    public DeliveryInitiationResponse initiateDelivery(DeliveryInitiationRequest request) {
        log.info("Initiating delivery for order: {}", request.getOrderId());
        
        // Assign warehouse location based on shipping address
        String warehouseLocation = assignWarehouse(request.getShippingAddress());
        
        // Determine delivery method
        String deliveryMethod = request.getPreferredDeliveryMethod() != null 
            ? request.getPreferredDeliveryMethod() : "STANDARD";
        
        // Assign shipping carrier
        String shippingCarrier = assignShippingCarrier(deliveryMethod);
        
        // Generate tracking ID
        String trackingId = generateTrackingId();
        
        // Calculate estimated delivery date
        LocalDateTime estimatedDeliveryDate = calculateEstimatedDeliveryDate(deliveryMethod);
        
        return new DeliveryInitiationResponse(
            request.getOrderId(),
            trackingId,
            warehouseLocation,
            deliveryMethod,
            shippingCarrier,
            estimatedDeliveryDate,
            "DELIVERY_INITIATED",
            "Delivery has been successfully initiated");
    }

    public PaymentCaptureResponse capturePayment(PaymentCaptureRequest request) {
        log.info("Capturing payment for order: {}", request.getOrderId());
        
        // Simulate payment capture process
        String transactionId = generateTransactionId();
        LocalDateTime capturedAt = LocalDateTime.now();
        
        // In real implementation, this would integrate with payment gateway
        boolean captureSuccess = simulatePaymentCapture(request);
        
        String status = captureSuccess ? "CAPTURED" : "FAILED";
        String message = captureSuccess 
            ? "Payment captured successfully" 
            : "Payment capture failed";
        
        return new PaymentCaptureResponse(
            request.getOrderId(),
            request.getPaymentId(),
            transactionId,
            request.getAmount(),
            request.getCurrency(),
            status,
            capturedAt,
            message);
    }

    public ShippingLabelResponse generateShippingLabel(ShippingLabelRequest request) {
        log.info("Generating shipping label for order: {}", request.getOrderId());
        
        // Generate label ID
        String labelId = generateLabelId();
        
        // Generate label URL (in real implementation, this would be actual label generation)
        String labelUrl = generateLabelUrl(labelId);
        
        // Simulate label data generation
        byte[] labelData = generateLabelData(request);
        
        ShippingLabelResponse response = new ShippingLabelResponse();
        response.setOrderId(request.getOrderId());
        response.setTrackingId(request.getTrackingId());
        response.setLabelId(labelId);
        response.setLabelUrl(labelUrl);
        response.setLabelData(labelData);
        response.setFormat("PDF");
        response.setGeneratedAt(LocalDateTime.now());
        response.setStatus("GENERATED");
        response.setMessage("Shipping label generated successfully");
        
        return response;
    }

    // Helper methods
    private boolean isProductExists(String productId) {
        // Simulate product existence check
        return !productId.equals("INVALID_PRODUCT");
    }

    private boolean isStockAvailable(String productId, Integer quantity) {
        // Simulate stock availability check
        return quantity <= 100; // Assume max stock is 100
    }

    private boolean isValidShippingAddress(OrderValidationRequest.ShippingAddress address) {
        // Basic address validation
        return address.getPostalCode() != null && 
               address.getPostalCode().matches("\\d{5}(-\\d{4})?");
    }

    private String assignWarehouse(OrderValidationRequest.ShippingAddress address) {
        // Simple warehouse assignment based on state
        String state = address.getState().toUpperCase();
        if (state.matches("CA|OR|WA|NV|AZ")) {
            return "WEST_COAST_WAREHOUSE";
        } else if (state.matches("NY|NJ|CT|MA|PA")) {
            return "EAST_COAST_WAREHOUSE";
        } else {
            return "CENTRAL_WAREHOUSE";
        }
    }

    private String assignShippingCarrier(String deliveryMethod) {
        switch (deliveryMethod) {
            case "EXPRESS":
                return "FedEx";
            case "OVERNIGHT":
                return "UPS";
            default:
                return "USPS";
        }
    }

    private String generateTrackingId() {
        return "TRK" + System.currentTimeMillis();
    }

    private String generateTransactionId() {
        return "TXN" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    private String generateLabelId() {
        return "LBL" + System.currentTimeMillis();
    }

    private LocalDateTime calculateEstimatedDeliveryDate(String deliveryMethod) {
        LocalDateTime now = LocalDateTime.now();
        switch (deliveryMethod) {
            case "OVERNIGHT":
                return now.plusDays(1);
            case "EXPRESS":
                return now.plusDays(2);
            default:
                return now.plusDays(5);
        }
    }

    private boolean simulatePaymentCapture(PaymentCaptureRequest request) {
        // Simulate payment capture (90% success rate)
        return Math.random() > 0.1;
    }

    private String generateLabelUrl(String labelId) {
        return "https://fulfillment-service/labels/" + labelId + ".pdf";
    }

    private byte[] generateLabelData(ShippingLabelRequest request) {
        // Simulate label data generation
        String labelContent = "SHIPPING LABEL\n" +
            "Order: " + request.getOrderId() + "\n" +
            "Tracking: " + request.getTrackingId() + "\n" +
            "To: " + request.getShippingAddress().getStreet() + "\n" +
            request.getShippingAddress().getCity() + ", " + 
            request.getShippingAddress().getState() + " " + 
            request.getShippingAddress().getPostalCode();
        
        return labelContent.getBytes();
    }
}