package com.ashiqursuperfly.smallcommercecompanion.models

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

data class ResponseModel<T>(
    val data: T,
    val detail: String = "Success",
) {
    fun build(status: HttpStatus): ResponseEntity<ResponseModel<T>>{
        return ResponseEntity<ResponseModel<T>>(this, status)
    }
}
