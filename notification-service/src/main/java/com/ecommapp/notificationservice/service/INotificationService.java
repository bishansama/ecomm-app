package com.ecommapp.notificationservice.service;

import com.ecommapp.notificationservice.model.NotificationRequest;
import com.ecommapp.notificationservice.model.NotificationResponse;

/**
 * Interface for Notification Service operations.
 * Defines the contract for notification delivery functionality.
 */
public interface INotificationService {
    
    /**
     * Sends a notification to the specified recipient using the requested delivery method.
     * 
     * @param request the notification details including recipient, message, and type
     * @return NotificationResponse containing delivery status and notification ID
     */
    NotificationResponse sendNotification(NotificationRequest request);
}