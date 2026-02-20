package com.example.backendcms.auth

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController(
    private val authService: AuthService
) {

    data class AuthRequest(
        val email: String,
        val password: String,
        val username: String? = null
    )

    @PostMapping("/register")
    fun register(@RequestBody req: AuthRequest): Map<String, String> {
        val token = authService.register(
            req.email,
            req.password,
            req.username ?: throw Exception("Username required")
        )

        return mapOf("token" to token)
    }

    @PostMapping("/login")
    fun login(@RequestBody req: AuthRequest): Map<String, String> {
        val token = authService.login(req.email, req.password)
        return mapOf("token" to token)
    }
}
