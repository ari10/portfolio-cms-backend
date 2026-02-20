package com.example.backendcms.auth

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import java.util.*

object JwtUtil {

    private const val SECRET_STRING = "my-super-secret-key-my-super-secret-key"

    private val SECRET = Keys.hmacShaKeyFor(SECRET_STRING.toByteArray())

    fun generateToken(email: String): String {
        return Jwts.builder()
            .setSubject(email)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + 86400000))
            .signWith(SECRET)
            .compact()
    }

    fun extractEmail(token: String): String {
        return Jwts.parserBuilder()
            .setSigningKey(SECRET)
            .build()
            .parseClaimsJws(token)
            .body
            .subject
    }
}