package com.example.backendcms.profile

import com.example.backendcms.user.User
import org.springframework.data.jpa.repository.JpaRepository

interface ProfileRepository : JpaRepository<Profile, Long> {
    fun findByUser(user: User): Profile?
}
