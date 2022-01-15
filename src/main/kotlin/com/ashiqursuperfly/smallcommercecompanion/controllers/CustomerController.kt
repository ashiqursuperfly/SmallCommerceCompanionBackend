package com.ashiqursuperfly.smallcommercecompanion.controllers

import com.ashiqursuperfly.smallcommercecompanion.base.SimpleCrudController
import com.ashiqursuperfly.smallcommercecompanion.models.Customer
import com.ashiqursuperfly.smallcommercecompanion.repositories.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
class CustomerController: SimpleCrudController<Customer, CustomerRepository>() {

    @Autowired
    lateinit var customerRepository: CustomerRepository

    override fun getRepository(): CustomerRepository {
        return customerRepository
    }


    @GetMapping("/customers/{id}")
    override fun get(@PathVariable id: String): ResponseEntity<ResponseModel<Customer?>> {
       return super.get(id)
    }

    @PostMapping("/customers")
    override fun post(@RequestBody data: Customer): ResponseEntity<ResponseModel<Customer?>> {
        return super.post(data)
    }

    @PutMapping("/customers/{id}")
    override fun put(@PathVariable id: String, @RequestBody data: Customer): ResponseEntity<ResponseModel<Customer?>> {
        return super.put(id, data)
    }

}