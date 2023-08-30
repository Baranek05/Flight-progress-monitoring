package com.example.server.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


    User findUserByLogin(String login);
    User findUserByName(String name);

    Optional<User> findByEmail(String email);

    Optional<User> findById(Long id);
}

