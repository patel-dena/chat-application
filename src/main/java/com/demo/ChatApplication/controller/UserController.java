package com.demo.ChatApplication.controller;

import com.demo.ChatApplication.entity.User;
import com.demo.ChatApplication.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Registration API
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userService.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already taken!");
        }
        return ResponseEntity.ok(userService.registerUser(user));
    }

    // Login API
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        boolean isValid = userService.validateUser(user.getUsername(), user.getPassword());
        if (isValid) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
