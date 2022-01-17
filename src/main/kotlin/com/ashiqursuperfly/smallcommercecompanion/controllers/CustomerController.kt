package com.ashiqursuperfly.smallcommercecompanion.controllers

import com.ashiqursuperfly.smallcommercecompanion.base.ResponseModel
import com.ashiqursuperfly.smallcommercecompanion.base.SimpleCrudController
import com.ashiqursuperfly.smallcommercecompanion.models.Customer
import com.ashiqursuperfly.smallcommercecompanion.repositories.BusinessRepository
import com.ashiqursuperfly.smallcommercecompanion.repositories.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
class CustomerController: SimpleCrudController<Long, Customer, CustomerRepository>() {

    @Autowired
    lateinit var customerRepository: CustomerRepository

    @Autowired
    lateinit var businessRepository: BusinessRepository

    override fun getRepository(): CustomerRepository {
        return customerRepository
    }

    @GetMapping("/customers/{businessId}/{customerId}")
    fun get(@PathVariable customerId: Long, @PathVariable businessId: Long): ResponseEntity<ResponseModel<Customer?>> {
        val customerResponse = super.get(customerId)
        if(customerResponse.body?.data?.businessId != businessId) {
            return ResponseModel<Customer?>(data=null, message="This is not a customer of this business: $businessId").build(HttpStatus.FORBIDDEN)
        }
        return customerResponse
    }

    @PostMapping("/customers/{businessId}")
    fun post(@PathVariable businessId: Long, @RequestBody data: Customer): ResponseEntity<ResponseModel<Customer?>> {
        val business = businessRepository.findById(businessId)
        if (business.isEmpty) {
            return ResponseModel<Customer?>(data=null, message="Invalid Business ID: $businessId").build(HttpStatus.FORBIDDEN)
        }
        val copied = data.copy(businessId = business.get().id)
        return super.post(copied)
    }

    @PutMapping("/customers/{customerId}")
    fun put(@RequestBody data: Customer, @PathVariable customerId: Long): ResponseEntity<ResponseModel<Customer?>> {
        return super.put(customerId, data)
    }

}