package com.example.server.security.jwt.token;

import com.example.server.security.jwt.token.Token;
import com.example.server.security.jwt.token.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenService {
    private final TokenRepository tokenRepository;

    public void saveToken(Token token) {
        tokenRepository.save(token);
    }

    public Optional<Token> getToken(String token) {
        return tokenRepository.findByToken(token);
    }

    public List<Token> getAllValidTokenByUser(Long id) {
        return tokenRepository.findAllValidTokenByUser(id);
    }

    public void saveAllTokens(List<Token> tokens) {
        tokenRepository.saveAll(tokens);
    }
}
