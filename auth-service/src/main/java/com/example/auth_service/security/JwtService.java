package com.example.auth_service.security;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {
    private static final String JWT_SECRET = "jwt_secret";

    public String generateToken(String username){
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(Jwts.SIG.HS256.key().build())
                .compact();
    }
}
