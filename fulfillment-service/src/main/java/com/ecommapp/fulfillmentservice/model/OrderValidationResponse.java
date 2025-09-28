package com.ecommapp.fulfillmentservice.model;

import java.util.List;

public class OrderValidationResponse {
    
    private String orderId;
    private boolean isValid;
    private String status;
    private List<ValidationError> errors;
    
    public OrderValidationResponse() {}
    
    public OrderValidationResponse(String orderId, boolean isValid, String status, List<ValidationError> errors) {
        this.orderId = orderId;
        this.isValid = isValid;
        this.status = status;
        this.errors = errors;
    }
    
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    
    public boolean isValid() { return isValid; }
    public void setValid(boolean valid) { isValid = valid; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public List<ValidationError> getErrors() { return errors; }
    public void setErrors(List<ValidationError> errors) { this.errors = errors; }
    
    public static class ValidationError {
        private String field;
        private String message;
        private String errorCode;
        
        public ValidationError() {}
        
        public ValidationError(String field, String message, String errorCode) {
            this.field = field;
            this.message = message;
            this.errorCode = errorCode;
        }
        
        public String getField() { return field; }
        public void setField(String field) { this.field = field; }
        
        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
        
        public String getErrorCode() { return errorCode; }
        public void setErrorCode(String errorCode) { this.errorCode = errorCode; }
    }
}