package com.example.server.user;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


//@Repository
public interface UserRepository extends JpaRepository<User, Integer> {



    Optional<User> findByEmail(String email);

    User save(User user);

    Optional<Object> findById(Long id);

}

