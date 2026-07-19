package com.example.books_service.service.notification;

import org.springframework.stereotype.Service;

@Service
public class EmailNotification implements NotificationService {
    @Override
    public void notify(String message) {
        System.out.println("email" + message);
    }
}
