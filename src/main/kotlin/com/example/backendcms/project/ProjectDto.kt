package com.example.backendcms.project

data class ProjectRequest(
    val title: String,
    val description: String,
    val techStack: String,
    val githubUrl: String?,
    val liveUrl: String?,
    val imageUrl: String?
)

data class ProjectResponse(
    val id: Long,
    val title: String,
    val description: String,
    val techStack: String,
    val githubUrl: String?,
    val liveUrl: String?,
    val imageUrl: String?
)
