package com.example.server.session;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/session")
public class SessionController {
    private final SessionService sessionService;

    @GetMapping("/shift")
    public ResponseEntity<Session> getUserLoginTimes() {
        Session session = sessionService.getUserLoginTimes();
        return new ResponseEntity<>(session, HttpStatus.OK);
    }

}

