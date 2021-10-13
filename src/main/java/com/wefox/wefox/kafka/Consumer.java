package com.wefox.wefox.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @KafkaListener(topics = "offline", groupId = "wefox")
    public void processMessageOffline(String content) {
        System.out.println("Message received: " + content);
    }
    @KafkaListener(topics = "online", groupId = "wefox")
    public void processMessageOnline(String content) {
        System.out.println("Message received: " + content);
    }
}