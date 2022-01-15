package com.ashiqursuperfly.smallcommercecompanion.controllers

import com.ashiqursuperfly.smallcommercecompanion.models.Business
import com.ashiqursuperfly.smallcommercecompanion.models.ResponseModel
import com.ashiqursuperfly.smallcommercecompanion.repositories.BusinessRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class BusinessController: SimpleCrudController<Business, BusinessRepository>() {

    @Autowired
    private lateinit var businessRepository: BusinessRepository

    @GetMapping("/businesses/{id}")
    override fun get(@PathVariable id: String): ResponseEntity<ResponseModel<Business?>> {
        return super.get(id)
    }

    @GetMapping("/businesses")
    override fun post(@RequestBody data: Business): ResponseEntity<ResponseModel<Business?>> {
        return super.post(data)
    }

    @PutMapping("/businesses/{id}")
    override fun put(@PathVariable id: String, @RequestBody data: Business): ResponseEntity<ResponseModel<Business?>> {
        return super.put(id, data)
    }

}