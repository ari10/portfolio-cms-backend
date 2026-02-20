package com.example.backendcms.auth

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter

class JwtFilter : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {

        val authHeader = request.getHeader("Authorization")

        if (authHeader != null && authHeader.startsWith("Bearer ")) {

            val token = authHeader.substring(7)

            try {
                val email = JwtUtil.extractEmail(token)

                val authentication = UsernamePasswordAuthenticationToken(
                    email,
                    null,
                    emptyList()
                )

                SecurityContextHolder.getContext().authentication = authentication

            } catch (e: Exception) {
                println("JWT Error: ${e.message}")
            }
        }

        filterChain.doFilter(request, response)
    }
}
