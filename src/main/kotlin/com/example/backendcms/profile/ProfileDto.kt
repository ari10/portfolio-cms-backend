package com.example.backendcms.profile

import jakarta.validation.constraints.NotBlank

// 🔹 Request untuk update / create profile
data class ProfileRequest(

    @field:NotBlank(message = "Full name wajib diisi")
    val fullName: String,

    @field:NotBlank(message = "Bio wajib diisi")
    val bio: String,

    val headline: String?,

    val avatarUrl: String?
)

// 🔹 Response untuk public / admin
data class ProfileResponse(
    val fullName: String,
    val bio: String,
    val headline: String?,
    val avatarUrl: String?
)