package com.example.server.service;

import com.example.server.model.User;
import com.example.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserData(String username) {
        User user = new User();
        return user;
    }

    User findUserByName(String name) {
        return userRepository.findUserByName(name);
    }

}
