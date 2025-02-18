package com.alejobeliz.projects.techforb.security;

import com.alejobeliz.projects.techforb.entity.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class JwtService {

    @Value("${jwt.secret.key}")
    private String secretKey;

    @Value("${jwt.expiration.time.seconds}")
    private int secondsExpirationTime;

    public String generateToken(Authentication authentication) {
        ClientUserDetail userDetailService = (ClientUserDetail) authentication.getPrincipal();
        User user = userDetailService.getUser();
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            return JWT.create()
                    .withIssuer("TechForb.Beliz")
                    .withSubject(user.getEmail())
                    .withClaim("Name", user.getUsername())
                    .withExpiresAt(generateDateOfExpiration())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new IllegalArgumentException("Error al generar token JWT: " + exception.getMessage(), exception);
        }
    }

    public DecodedJWT validarToken(String tokenJWT) {
        try {
            Algorithm algoritmo = Algorithm.HMAC256(secretKey);
            JWTVerifier verifier=JWT.require(algoritmo)
                    .withIssuer("TechForb.Beliz")
                    .build();
             DecodedJWT decodedToken = verifier.verify(tokenJWT);
             return decodedToken;
        } catch (JWTVerificationException exception) {
            throw new IllegalArgumentException("Token JWT inválido o expirado: " + exception.getMessage(), exception);
        }
    }

    public String getEmailOfToken(DecodedJWT tokenDecodificado) {
        return tokenDecodificado.getSubject();
    }

    private Instant generateDateOfExpiration() {
       return expirationDate();
    }

    private Instant calculateExpirationDate() {
        ZonedDateTime ahora = ZonedDateTime.now(ZoneId.of("-03:00"));
        ZonedDateTime expirationDate = ahora.withHour(23).withMinute(59).withSecond(0).withNano(0);
        if (ahora.isAfter(expirationDate)) {
            expirationDate = expirationDate.plusDays(1);
        }
        return expirationDate.toInstant();
    }

    private Instant expirationDate() {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("-03:00"));
        return now.plusSeconds(secondsExpirationTime).toInstant();
    }
}
