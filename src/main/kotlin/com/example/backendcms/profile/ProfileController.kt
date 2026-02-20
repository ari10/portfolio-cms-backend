package com.example.backendcms.profile

import com.example.backendcms.common.BaseResponse
import com.example.backendcms.user.UserRepository
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/profile")
class ProfileController(
    private val profileService: ProfileService,
    private val userRepository: UserRepository,
    private val profileRepository: ProfileRepository
) {

    // 🔐 ADMIN - update profile
    @PutMapping
    fun updateProfile(@Valid @RequestBody req: ProfileRequest): BaseResponse<ProfileResponse> {
        val result = profileService.updateProfile(req)
        return BaseResponse(true, "Profile updated", result)
    }

    // 🌍 PUBLIC - get profile by username
    @GetMapping("/{username}")
    fun getProfile(@PathVariable username: String): ProfileResponse {

        val user = userRepository.findByUsername(username)
            ?: throw Exception("User not found")

        val profile = profileRepository.findByUser(user)
            ?: throw Exception("Profile not found")

        return ProfileResponse(
            fullName = profile.fullName,
            bio = profile.bio,
            headline = profile.headline,
            avatarUrl = profile.avatarUrl
        )
    }
}
