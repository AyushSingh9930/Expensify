package com.Project.ExpenseTracker.Jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.JwtException;  // For catching exceptions
import java.util.Collections;
import java.util.List;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class JwtUtil {
    private final String SECRET="mysecretkeymysecretkeymysecretkey";
    private final long EXPIRATION_MS=1000*60*60*24;
    private Key getSigningKey(){
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        // Add authorities/roles as a claim (fetched from UserDetails)
        claims.put("authorities", userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList()));

        return Jwts.builder()
                .setClaims(claims)  // Include the custom claims
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    public boolean isTokenValid(String token,UserDetails userDetails){
        try{
            String username=extractUsername(token);
            return username.equals(userDetails.getUsername()) && ! isTokenExpired(token);
        }catch (Exception e){
            return false;
        }
    }
    private boolean isTokenExpired(String token){
        Date expiration=Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build().parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expiration.before(new Date());
    }


    public List<String> extractAuthorities(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            // Safer retrieval with type check and null handling
            @SuppressWarnings("unchecked")
            List<String> authorities = (List<String>) claims.get("authorities");
            return authorities != null ? authorities : Collections.emptyList();
        } catch (JwtException e) {
            // Log the error (add your logger here)
            System.out.println("JWT parsing error: " + e.getMessage());
            return Collections.emptyList();  // Or throw if preferred
        }
    }
}
