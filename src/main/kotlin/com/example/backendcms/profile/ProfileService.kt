package com.example.backendcms.profile

import com.example.backendcms.user.User
import com.example.backendcms.user.UserRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class ProfileService(
    private val profileRepository: ProfileRepository,
    private val userRepository: UserRepository
) {

    fun getCurrentUserEmail(): String {
        return SecurityContextHolder.getContext().authentication?.name
            ?: throw Exception("Unauthorized")
    }
    fun getCurrentUser(): User {
        val email = SecurityContextHolder.getContext().authentication?.name
            ?: throw Exception("Unauthorized")

        return userRepository.findByEmail(email)
            ?: throw Exception("User not found")
    }

    fun updateProfile(req: ProfileRequest): ProfileResponse {

        val email = getCurrentUserEmail()

        val user = userRepository.findByEmail(email)
            ?: throw Exception("User not found")

        var profile = profileRepository.findByUser(user)

        if (profile == null) {
            profile = Profile(
                user = user,
                fullName = req.fullName,
                bio = req.bio,
                headline = req.headline,
                avatarUrl = req.avatarUrl
            )
        } else {
            profile = profile.copy(
                fullName = req.fullName,
                bio = req.bio,
                headline = req.headline,
                avatarUrl = req.avatarUrl
            )
        }

        profileRepository.save(profile)

        return ProfileResponse(
            fullName = profile.fullName,
            bio = profile.bio,
            headline = profile.headline,
            avatarUrl = profile.avatarUrl
        )
    }
}
