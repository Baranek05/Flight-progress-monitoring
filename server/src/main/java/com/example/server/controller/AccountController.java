package com.example.server.controller;

/*
@RestController
@RequestMapping("/account")
public class AccountController {

    private final UserRepository userRepository;

    public AccountController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String account(Model model) {
        return "account";
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> accountInfo(@PathVariable String username) {
        User user = userRepository.getUserData(username);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }
}

*/