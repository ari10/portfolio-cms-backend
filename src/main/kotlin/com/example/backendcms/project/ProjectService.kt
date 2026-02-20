package com.example.backendcms.project

import com.example.backendcms.user.UserRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import org.springframework.data.domain.PageRequest

@Service
class ProjectService(
    private val projectRepository: ProjectRepository,
    private val userRepository: UserRepository
) {

    private fun getCurrentUser() =
        userRepository.findByEmail(
            SecurityContextHolder.getContext().authentication?.name
                ?: throw Exception("Unauthorized")
        ) ?: throw Exception("User not found")

    fun create(req: ProjectRequest): ProjectResponse {
        val user = getCurrentUser()

        val project = Project(
            user = user,
            title = req.title,
            description = req.description,
            techStack = req.techStack,
            githubUrl = req.githubUrl,
            liveUrl = req.liveUrl,
            imageUrl = req.imageUrl
        )

        projectRepository.save(project)

        return toResponse(project)
    }

    fun getByUsername(username: String, page: Int, size: Int): List<ProjectResponse> {

        val user = userRepository.findByUsername(username)
            ?: throw Exception("User not found")

        val pageable = PageRequest.of(page, size)

        return projectRepository.findByUser(user, pageable)
            .content
            .map { toResponse(it) }
    }

    fun update(id: Long, req: ProjectRequest): ProjectResponse {
        val user = getCurrentUser()

        val project = projectRepository.findById(id)
            .orElseThrow { Exception("Project not found") }

        if (project.user.id != user.id) {
            throw Exception("Forbidden")
        }

        val updated = project.copy(
            title = req.title,
            description = req.description,
            techStack = req.techStack,
            githubUrl = req.githubUrl,
            liveUrl = req.liveUrl,
            imageUrl = req.imageUrl
        )

        projectRepository.save(updated)

        return toResponse(updated)
    }

    fun delete(id: Long) {
        val user = getCurrentUser()

        val project = projectRepository.findById(id)
            .orElseThrow { Exception("Project not found") }

        if (project.user.id != user.id) {
            throw Exception("Forbidden")
        }

        projectRepository.delete(project)
    }

    private fun toResponse(p: Project) = ProjectResponse(
        id = p.id,
        title = p.title,
        description = p.description,
        techStack = p.techStack,
        githubUrl = p.githubUrl,
        liveUrl = p.liveUrl,
        imageUrl = p.imageUrl
    )
}
