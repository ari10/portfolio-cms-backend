package com.example.backendcms.project

import com.example.backendcms.common.BaseResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/projects")
class ProjectController(
    private val projectService: ProjectService
) {

    // 🔐 create
    @PostMapping
    fun create(@RequestBody req: ProjectRequest) =
        projectService.create(req)

    // 🌍 public
    @GetMapping("/{username}")
    fun getByUsername(
        @PathVariable username: String,
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "10") size: Int
    ): BaseResponse<List<ProjectResponse>> {

        val result = projectService.getByUsername(username, page, size)
        return BaseResponse(true, "Success", result)
    }

    // 🔐 update
    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody req: ProjectRequest
    ) = projectService.update(id, req)

    // 🔐 delete
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) =
        projectService.delete(id)
}
