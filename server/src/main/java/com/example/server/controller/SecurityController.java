package com.example.server.controller;

import com.example.server.model.User;
import com.example.server.security.AuthenticationRequest;
import com.example.server.security.AuthenticationResponse;
import com.example.server.security.AuthenticationService;
import com.example.server.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;

import java.net.URI;

@RestController
@AllArgsConstructor
//@CrossOrigin(origins = "http://localhost:63342")
@RequestMapping("/security")
public class SecurityController {




    //@Autowired
    private final UserService userService;
    private final AuthenticationService authenticationService;

   // @Autowired
   //private final AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        /* User user = userService.findUserByLogin(loginUser.getLogin());

        if (user != null && user.getPassword().equals(loginUser.getPassword()) && user.getLogin().equals(loginUser.getLogin())) {
            URI menuUri = URI.create("/menu");
            return ResponseEntity.status(HttpStatus.FOUND).location(menuUri).build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } */

        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
    /*
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String login, @RequestParam String password) {
        User user = userService.findUserByLogin(login);

        if (user != null && user.getPassword().equals(password) && user.getLogin().equals(login)) {
            URI menuUri = URI.create("/menu");
            return ResponseEntity.status(HttpStatus.FOUND).location(menuUri).build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    } */
}

