package com.demo.ChatApplication.controller;

import com.demo.ChatApplication.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat.sendMessage")  // /app/chat.sendMessage
    @SendTo("/topic/public")              // broadcast to /topic/public
    public ChatMessage sendMessage(ChatMessage chatMessage) {
        return chatMessage;
    }

    @PostMapping("/api/chat")
    public String sendMessageViaRest(@RequestBody ChatMessage chatMessage) {
        messagingTemplate.convertAndSend("/topic/public", chatMessage);
        return "✅ Message broadcasted via REST";
    }

    @GetMapping("/")
    public String home() {
        return "✅ Chat Application is running! Use /api/chat or connect WebSocket at /ws";
    }
}
