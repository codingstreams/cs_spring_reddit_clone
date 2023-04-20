package com.codingstreams.redditclone.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {
    @Value("${jwt.secret}")
    private String secretKey;
    @Value("${jwt.expiration}")
    private String expirationInMillis;

    private Claims parseToken(String token) {
        // Create Jwt parser
        var jwtParser = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build();

        try {
            return jwtParser.parseClaimsJws(token)
                    .getBody();

        } catch (ExpiredJwtException e) {
            throw new RuntimeException(e);
        } catch (MalformedJwtException e) {
            throw new RuntimeException(e);
        } catch (SignatureException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean validateToken(String token) {
        try {
            parseToken(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String generateToken(String username) {
        var issuedAt = new Date();
        var expiration = new Date(issuedAt.getTime() + expirationInMillis);

        // Generate token
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(issuedAt)
                .setExpiration(expiration)
                .signWith(getSigningKey())
                .setIssuer("Coding Streams")
                .compact();
    }

    public String getUsernameFromToken(String token) {
        var claims = parseToken(token);
        return claims.getSubject();
    }

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }
}
