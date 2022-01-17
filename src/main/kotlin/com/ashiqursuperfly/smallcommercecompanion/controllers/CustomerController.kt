package com.ashiqursuperfly.smallcommercecompanion.controllers

import com.ashiqursuperfly.smallcommercecompanion.base.SimpleCrudController
import com.ashiqursuperfly.smallcommercecompanion.models.Customer
import com.ashiqursuperfly.smallcommercecompanion.repositories.BusinessRepository
import com.ashiqursuperfly.smallcommercecompanion.repositories.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
class CustomerController: SimpleCrudController<Customer, CustomerRepository>() {

    @Autowired
    lateinit var customerRepository: CustomerRepository

    @Autowired
    lateinit var businessRepository: BusinessRepository

    override fun getRepository(): CustomerRepository {
        return customerRepository
    }

    @GetMapping("/customers/{id}")
    fun get(@PathVariable id: String, @PathVariable businessID: String): ResponseEntity<ResponseModel<Customer?>> {
        val customerResponse = super.get(id)
        if(customerResponse.body?.data?.business?.id != businessID) {
            return ResponseModel<Customer?>(data=null, message="This is not a customer of this business: $businessID").build(HttpStatus.FORBIDDEN)
        }
        return customerResponse
    }

    @PostMapping("/customers")
    fun post(@RequestBody data: Customer, @RequestParam(required = true) businessID: String): ResponseEntity<ResponseModel<Customer?>> {
        val business = businessRepository.findById(businessID)
        if (business.isEmpty) {
            return ResponseModel<Customer?>(data=null, message="Invalid Business ID: $businessID").build(HttpStatus.FORBIDDEN)
        }
        val copied = data.copy(business = business.get())
        return super.post(copied)
    }

    @PutMapping("/customers/{id}")
    override fun put(@PathVariable id: String, @RequestBody data: Customer): ResponseEntity<ResponseModel<Customer?>> {
        return super.put(id, data)
    }

}