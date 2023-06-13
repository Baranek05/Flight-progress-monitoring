package com.example.server.repository;

import com.example.server.model.User;

import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


    User findUserByLogin(String login);
    User findUserByName(String name);



}

