package com.ecommapp.notificationservice.model;

import java.time.LocalDateTime;

public class NotificationResponse {
    
    private String notificationId;
    private String recipient;
    private String subject;
    private NotificationType type;
    private String status;
    private LocalDateTime sentAt;
    private String message;
    
    // No-argument constructor
    public NotificationResponse() {}
    
    // All-argument constructor
    public NotificationResponse(String notificationId, String recipient, String subject, 
                              NotificationType type, String status, LocalDateTime sentAt, String message) {
        this.notificationId = notificationId;
        this.recipient = recipient;
        this.subject = subject;
        this.type = type;
        this.status = status;
        this.sentAt = sentAt;
        this.message = message;
    }
    
    // Getters and Setters
    public String getNotificationId() {
        return notificationId;
    }
    
    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }
    
    public String getRecipient() {
        return recipient;
    }
    
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public NotificationType getType() {
        return type;
    }
    
    public void setType(NotificationType type) {
        this.type = type;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public LocalDateTime getSentAt() {
        return sentAt;
    }
    
    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
}