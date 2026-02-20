package com.example.backendcms.common

import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.File

@RestController
@RequestMapping("/api/upload")
class UploadController {

    private val uploadDir = "uploads/"

    @PostMapping
    fun upload(@RequestParam("file") file: MultipartFile): BaseResponse<String> {

        val fileName = System.currentTimeMillis().toString() + "_" + file.originalFilename

        val dest = File(uploadDir + fileName)
        dest.parentFile.mkdirs()

        file.transferTo(dest)

        val fileUrl = "http://localhost:8080/uploads/$fileName"

        return BaseResponse(true, "Upload success", fileUrl)
    }
}