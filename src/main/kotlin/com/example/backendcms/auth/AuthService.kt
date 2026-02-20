package com.example.backendcms.auth

import com.example.backendcms.user.User
import com.example.backendcms.user.UserRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userRepository: UserRepository
) {

    private val encoder = BCryptPasswordEncoder()

    fun register(email: String, password: String, username: String): String {

        if (userRepository.findByEmail(email) != null) {
            throw Exception("Email already used")
        }

        val user = User(
            email = email,
            password = encoder.encode(password),
            username = username
        )

        userRepository.save(user)

        // 🔥 generate token setelah save
        return JwtUtil.generateToken(email)
    }


    fun login(email: String, password: String): String {

        val user = userRepository.findByEmail(email)
            ?: throw Exception("User not found")

        if (!encoder.matches(password, user.password)) {
            throw Exception("Invalid password")
        }

        return JwtUtil.generateToken(email)
    }
}
