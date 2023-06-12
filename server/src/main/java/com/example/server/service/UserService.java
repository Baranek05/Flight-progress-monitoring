package com.example.server.service;

import com.example.server.model.User;
import com.example.server.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
/*
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    } */

    @Transactional
    public User findUserByLogin(String login) {
        //User user = new User();
        return userRepository.findUserByLogin(login);
    }

    @Transactional
    User findUserByName(String name) {
        return userRepository.findUserByName(name);
    }

}
