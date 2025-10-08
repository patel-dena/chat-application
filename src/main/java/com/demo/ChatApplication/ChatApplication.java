package com.demo.ChatApplication;

import com.demo.ChatApplication.repository.MessageRepository;
import com.demo.ChatApplication.repository.UserRepository;
import com.demo.ChatApplication.service.MessageService;
import com.demo.ChatApplication.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatApplication.class, args);
	}

}
