package com.example.server.controller;

import com.example.server.model.User;
import com.example.server.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
//@CrossOrigin(origins = "http://localhost:63342")
@RequestMapping("/security")
public class SecurityController {




    //@Autowired
    private final UserService userService;

   // @Autowired
   // private final AuthenticationManager authenticationManager;


    public SecurityController(UserService userService) {

        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String login, @RequestParam String password) {
        User user = userService.findUserByLogin(login);

        if (user != null && user.getPassword().equals(password) && user.getLogin().equals(login)) {
            URI menuUri = URI.create("/menu");
            return ResponseEntity.status(HttpStatus.FOUND).location(menuUri).build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }
}

