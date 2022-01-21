package com.ashiqursuperfly.smallcommercecompanion.base

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

data class ResponseModel<T>(
    val data: T? = null,
    val message: String = "Success",
) {
    fun build(status: HttpStatus): ResponseEntity<ResponseModel<T>>{
        return ResponseEntity<ResponseModel<T>>(this, status)
    }
}
