package com.example.server.security.jwt.token;

import com.example.server.security.jwt.token.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {

    List<Token> findAllValidTokenByUser(Long id);

    Optional<Token> findByToken(String token);
}
