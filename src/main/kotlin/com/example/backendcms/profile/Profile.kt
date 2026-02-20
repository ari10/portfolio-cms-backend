package com.example.backendcms.profile

import com.example.backendcms.user.User
import jakarta.persistence.*

@Entity
@Table(name = "profiles")
data class Profile(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @OneToOne
    @JoinColumn(name = "user_id")
    val user: User,

    val fullName: String,
    val bio: String,
    val headline: String?,
    val avatarUrl: String?
)
