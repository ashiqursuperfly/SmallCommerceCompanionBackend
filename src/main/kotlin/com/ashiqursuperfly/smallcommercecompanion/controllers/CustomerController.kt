package com.ashiqursuperfly.smallcommercecompanion.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class CustomerController {
    @GetMapping("/")
    fun index(): String {
        return "Greetings from Spring Boot!"
    }
}