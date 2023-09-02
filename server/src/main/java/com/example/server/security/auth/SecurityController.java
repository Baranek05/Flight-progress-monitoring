package com.example.server.security.auth;

import com.example.server.user.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class SecurityController {

    private final AuthenticationService authenticationService;


   @PostMapping("/register")
   public ResponseEntity<AuthenticationResponse> register(
           @RequestBody RegisterRequest request) {
       return ResponseEntity.ok(authenticationService.register(request));
   }

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

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    )throws IOException {
        authenticationService.refreshToken(request,response);
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

