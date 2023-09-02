package com.example.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "http://localhost:3000")
public class MenuController {
/*
    @GetMapping
    public String menu() {
        // Renderowanie strony menu lub wyświetlanie odpowiednich danych
        // Tu możesz umieścić odpowiedni kod do renderowania menu
        return "Menu Page";
    }

    @GetMapping("/next")
    public ResponseEntity<String> next() {
        // Przekierowanie do kolejnego endpointa
        URI atcUri = URI.create("/atc");
        return ResponseEntity.status(HttpStatus.FOUND).location(atcUri).build();
    } */

    @GetMapping("/logout")
    public ResponseEntity<String> logout() {
        // Wylogowanie użytkownika
        // Tu możesz umieścić kod odpowiedzialny za wylogowanie, np. zniszczenie sesji
        // Następnie przekierowanie do strony logowania
        URI loginUri = URI.create("/login");
        return ResponseEntity.status(HttpStatus.FOUND).location(loginUri).build();
    }
}

