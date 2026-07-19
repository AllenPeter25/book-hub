package com.example.books_service.service.notification;

import org.springframework.stereotype.Service;

@Service
public class SMSNotification implements NotificationService {
    @Override
    public void notify(String message) {
        System.out.println("sms" + message);
    }
}
