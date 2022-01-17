package com.ashiqursuperfly.smallcommercecompanion.controllers

import com.ashiqursuperfly.smallcommercecompanion.base.SimpleCrudController
import com.ashiqursuperfly.smallcommercecompanion.models.Business
import com.ashiqursuperfly.smallcommercecompanion.repositories.BusinessRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class BusinessController: SimpleCrudController<Business, BusinessRepository>() {

    @Autowired
    lateinit var customerRepository: BusinessRepository

    override fun getRepository(): BusinessRepository {
        return customerRepository
    }

    @GetMapping("/business/{id}")
    override fun get(@PathVariable id: String): ResponseEntity<ResponseModel<Business?>> {
        return super.get(id)
    }

    @PostMapping("/business")
    override fun post(@RequestBody data: Business): ResponseEntity<ResponseModel<Business?>> {
        return super.post(data)
    }

    @PutMapping("/business/{id}")
    override fun put(@PathVariable id: String, @RequestBody data: Business): ResponseEntity<ResponseModel<Business?>> {
        return super.put(id, data)
    }

}