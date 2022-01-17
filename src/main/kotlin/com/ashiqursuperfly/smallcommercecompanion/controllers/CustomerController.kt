package com.ashiqursuperfly.smallcommercecompanion.controllers

import com.ashiqursuperfly.smallcommercecompanion.base.ResponseModel
import com.ashiqursuperfly.smallcommercecompanion.base.SimpleCrudController
import com.ashiqursuperfly.smallcommercecompanion.models.Const
import com.ashiqursuperfly.smallcommercecompanion.models.Customer
import com.ashiqursuperfly.smallcommercecompanion.repositories.BusinessRepository
import com.ashiqursuperfly.smallcommercecompanion.repositories.CustomerRepository
import com.ashiqursuperfly.smallcommercecompanion.services.SequenceGeneratorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/customer")
class CustomerController : SimpleCrudController<Long, Customer, CustomerRepository>() {

    @Autowired
    lateinit var sequenceGenerator: SequenceGeneratorService

    @Autowired
    lateinit var customerRepository: CustomerRepository

    @Autowired
    lateinit var businessRepository: BusinessRepository

    override fun getCrudRepository(): CustomerRepository {
        return customerRepository
    }

    @GetMapping
    fun get(@RequestHeader(required = true) secretAccessKey: String): ResponseEntity<ResponseModel<List<Customer>?>> {
        val business = businessRepository.findBusinessBySecretAccessKey(secretAccessKey)
            ?: return ResponseModel<List<Customer>?>(
                data = null,
                message = "Invalid/Missing business secret access key"
            ).build(HttpStatus.FORBIDDEN)

        val customers = customerRepository.findAllCustomersOfThisBusiness(business.id)

        return ResponseModel<List<Customer>?>(data = customers).build(HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun get(
        @RequestHeader(required = true) secretAccessKey: String,
        @PathVariable id: Long
    ): ResponseEntity<ResponseModel<Customer?>> {
        val customerResponse = super.get(id)
        val business = businessRepository.findBusinessBySecretAccessKey(secretAccessKey)

        if (customerResponse.body?.data?.businessId != business?.id) {
            return ResponseModel<Customer?>(
                data = null,
                message = "This is not a customer of this business: ${business?.id}"
            ).build(HttpStatus.FORBIDDEN)
        }
        return customerResponse
    }

    @PostMapping
    fun post(
        @RequestHeader(required = true) secretAccessKey: String,
        @RequestBody data: Customer
    ): ResponseEntity<ResponseModel<Customer?>> {
        val business = businessRepository.findBusinessBySecretAccessKey(secretAccessKey)
            ?: return ResponseModel<Customer?>(
                data = null,
                message = "Invalid/Missing business secret access key"
            ).build(HttpStatus.FORBIDDEN)

        val copied = data.copy(
            id = sequenceGenerator.generateSequence(Const.Mongo.SEQUENCES.CUSTOMER_SEQUENCE),
            businessId = business.id
        )
        return super.post(copied)
    }

    @PutMapping("/{id}")
    fun put(
        @RequestHeader(required = true) secretAccessKey: String,
        @RequestBody data: Customer,
        @PathVariable id: Long
    ): ResponseEntity<ResponseModel<Customer?>> {
        val business = businessRepository.findBusinessBySecretAccessKey(secretAccessKey)
            ?: return ResponseModel<Customer?>(
                data = null,
                message = "Invalid/Missing business secret access key"
            ).build(HttpStatus.FORBIDDEN)
        val customer = super.get(id)
        if (customer.body?.data?.businessId != business.id) {
            return ResponseModel<Customer?>(
                data = null,
                message = "This is not a customer of this business: ${business.id}"
            ).build(HttpStatus.FORBIDDEN)
        }
        return super.put(id, data)
    }

}