package com.example.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    protected String render(String template, Model model) {
        return template;
    }

}
