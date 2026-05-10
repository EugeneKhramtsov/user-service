package uu.app.userservice.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private static final long TEN_HOURS = 1000 * 60 * 60 * 10;
    private final String SECRET_KEY = "AyM1SysPpbyDfgZld3umj1qzKObwVMkoqQEstJQLrT1qS0gZH75aKtMN3Yj0iPS4hcgUuTwjAzZr1Z9CAow";

    public String generateToken(String username, String role) {
        return Jwts.builder()
                .subject(username)
                .claim("role", role)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + TEN_HOURS))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes())
                .compact();
    }

    public Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY.getBytes())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
