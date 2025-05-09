package com.example.demo.auth.service;

import com.example.demo.auth.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtService {

    String secretKey = "VExWZ3hzNkdjN2hmd3Zqd2t+fm2MlJlU5du/4G9ExdsFz6jCBBgVKBrk93qZroA6TK8zo8FYoM=VExWZ3hzNkdjN2hmd3Zqd2t+fm2MlJlU5du/4G9ExdsFz6jCBBgVKBrk93qZroA6TK8zo8FYoM=";

    private static final long EXPIRATION_TIME = 864_000_000;

    public String generarToken(String username) {
        Date ahora = new Date();
        Date expirationDate = new Date(ahora.getTime() + EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(ahora)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public String extraerUsername(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean esValido(String token, UserDetails userDetails) {
        return extraerUsername(token).equals(userDetails.getUsername());
    }
}