package com.bitirmeprojesi.eticaret.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class JWTService {

    @Value("${jwt.secretkey}")
    private String SECRET_KEY;

    public String  verifyJwtToken(String username){
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY.getBytes());
        String access_token = JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000*60*60*24))
                .sign(algorithm);
        return access_token;
    }


    public String getProp(String key) {
        return null;
    }

    public String getSubject(String jwt) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY.getBytes());
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(jwt);
        String subject = decodedJWT.getSubject();
        return subject;
    }
}
