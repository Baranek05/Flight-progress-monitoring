package com.example.server.security.auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;


    @PostMapping("/register")
   public ResponseEntity<AuthenticationResponse> register(
           @RequestBody RegisterRequest request) {
       return ResponseEntity.ok(authenticationService.register(request));
   }

   @PostMapping("/login")
   public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
   }

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    )throws IOException {
        authenticationService.refreshToken(request,response);
    }

}

