package com.example.backendcms.common

import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.*

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleGeneral(ex: Exception): BaseResponse<Nothing> {
        return BaseResponse(
            success = false,
            message = ex.message ?: "Error"
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleValidation(ex: MethodArgumentNotValidException): BaseResponse<Nothing> {
        val error = ex.bindingResult.fieldErrors.firstOrNull()?.defaultMessage
        return BaseResponse(
            success = false,
            message = error ?: "Validation error"
        )
    }
}