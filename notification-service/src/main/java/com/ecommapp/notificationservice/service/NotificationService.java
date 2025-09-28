package com.ecommapp.notificationservice.service;

import com.ecommapp.notificationservice.model.NotificationRequest;
import com.ecommapp.notificationservice.model.NotificationResponse;
import com.ecommapp.notificationservice.model.NotificationType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
@Service
@Slf4j
public class NotificationService implements INotificationService {    
    public NotificationResponse sendNotification(NotificationRequest request) {
        // Generate unique notification ID
        String notificationId = UUID.randomUUID().toString();
        
        // Simulate notification sending logic
        String status = processNotification(request);
        
        // Create response
        return new NotificationResponse(
            notificationId,
            request.getRecipient(),
            request.getSubject(),
            request.getType(),
            status,
            LocalDateTime.now(),
            "Notification processed successfully"
        );
    }
    
    private String processNotification(NotificationRequest request) {
        // Simulate different processing based on notification type
        switch (request.getType()) {
            case EMAIL:
                return sendEmail(request);
            case SMS:
                return sendSms(request);
            case PUSH:
                return sendPushNotification(request);
            case IN_APP:
                return sendInAppNotification(request);
            default:
                return "FAILED";
        }
    }
    
    private String sendEmail(NotificationRequest request) {
        // Simulate email sending
        System.out.println("Sending email to: " + request.getRecipient());
        System.out.println("Subject: " + request.getSubject());
        System.out.println("Message: " + request.getMessage());
        return "SENT";
    }
    
    private String sendSms(NotificationRequest request) {
        // Simulate SMS sending
        System.out.println("Sending SMS to: " + request.getRecipient());
        System.out.println("Message: " + request.getMessage());
        return "SENT";
    }
    
    private String sendPushNotification(NotificationRequest request) {
        // Simulate push notification sending
        System.out.println("Sending push notification to: " + request.getRecipient());
        System.out.println("Title: " + request.getSubject());
        System.out.println("Message: " + request.getMessage());
        return "SENT";
    }
    
    private String sendInAppNotification(NotificationRequest request) {
        // Simulate in-app notification
        System.out.println("Sending in-app notification to: " + request.getRecipient());
        System.out.println("Message: " + request.getMessage());
        return "SENT";
    }
}