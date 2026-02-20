package com.example.backendcms.project

import com.example.backendcms.user.User
import jakarta.persistence.*

@Entity
@Table(name = "projects")
data class Project(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User,

    val title: String,
    val description: String,
    val techStack: String,
    val githubUrl: String?,
    val liveUrl: String?,
    val imageUrl: String?
)
