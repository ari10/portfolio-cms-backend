package com.example.backendcms.common

data class BaseResponse<T>(
    val success: Boolean,
    val message: String,
    val data: T? = null
)