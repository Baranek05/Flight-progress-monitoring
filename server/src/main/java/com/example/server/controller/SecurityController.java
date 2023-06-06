package com.example.server.controller;

import com.example.server.repository.UserRepository;
import com.example.server.model.User;
import com.example.server.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class SecurityController {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    public SecurityController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        User user = userRepository.getUser(username);

        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found!");
        }

        if (!user.getLogin().equals(username)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User with this login not exist!");
        }

        if (!user.getPassword().equals(password)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong password!");
        }

        return ResponseEntity.ok().build();
    }
}

