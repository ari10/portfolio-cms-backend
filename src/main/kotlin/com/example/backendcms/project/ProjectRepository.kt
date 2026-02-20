package com.example.backendcms.project

import com.example.backendcms.user.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository : JpaRepository<Project, Long> {
    fun findByUser(user: User, pageable: Pageable): Page<Project>
}