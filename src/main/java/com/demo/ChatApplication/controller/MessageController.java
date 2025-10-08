package com.demo.ChatApplication.controller;

import com.demo.ChatApplication.entity.Message;
import com.demo.ChatApplication.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class MessageController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private MessageService messageService;

    @MessageMapping("/chat.sendMessage")  // /app/chat.sendMessage
    @SendTo("/topic/public")              // broadcast to /topic/public
    public Message sendMessage(Message message) {
        return messageService.saveMessage(message);
    }

//    @GetMapping("/")
//    public String home() {
//        return "✅ Chat Application is running! Use /api/chat or connect WebSocket at /ws";
//    }
}
