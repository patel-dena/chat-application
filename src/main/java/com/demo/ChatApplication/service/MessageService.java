package com.demo.ChatApplication.service;

import com.demo.ChatApplication.entity.Message;
import com.demo.ChatApplication.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    public List<Message> findBySender(String sender) {
        return messageRepository.findBySender(sender);
    }
}
