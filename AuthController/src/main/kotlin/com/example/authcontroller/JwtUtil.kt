package com.example.authcontroller


import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.security.Key
import java.util.Date


@Component
class JwtUtil {


    private val secretKey: Key = Keys.hmacShaKeyFor("mysecretkeymysecretkeymysecretkey123".toByteArray())

    private val expirationMs = 86400000

    fun generateToken(username: String): String{
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + expirationMs))
            .signWith(secretKey, SignatureAlgorithm.HS256)
            .compact()
    }

    fun extractUsername(token: String): String{
        return Jwts.parserBuilder()
            .setSigningKey(secretKey)
            .build()
            .parseClaimsJws(token)
            .body
            .subject
    }


    fun isTokenValid(token: String, username: String): Boolean {
        val extracted = extractUsername(token)
        return extracted == username && !isTokenExpired(token)
    }

    fun isTokenExpired(token: String): Boolean {
        return Jwts.parserBuilder()
            .setSigningKey(secretKey)
            .build()
            .parseClaimsJws(token)
            .body
            .expiration
            .before(Date())
    }


}