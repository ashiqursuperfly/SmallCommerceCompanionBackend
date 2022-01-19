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

    @GetMapping("/{id}")
    fun get(
        @RequestHeader(required = true) secretAccessKey: String,
        @PathVariable id: Long
    ): ResponseEntity<ResponseModel<Customer?>> {
        val validationFailure = validateHeaderAndPath(secretAccessKey, id)
        if (validationFailure != null) return validationFailure
        return super.get(id)
    }

    @GetMapping
    fun getAll(@RequestHeader(required = true) secretAccessKey: String): ResponseEntity<ResponseModel<List<Customer>?>> {
        val business = businessRepository.findBusinessBySecretAccessKey(secretAccessKey)
            ?: return ResponseModel<List<Customer>?>(
                data = null,
                message = "Invalid/Missing business secret access key"
            ).build(HttpStatus.FORBIDDEN)

        val customers = customerRepository.findAllCustomersOfThisBusiness(business.id)

        return ResponseModel<List<Customer>?>(data = customers).build(HttpStatus.OK)
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
        val validationFailure = validateHeaderAndPath(secretAccessKey, id)
        if (validationFailure != null) return validationFailure
        return super.put(id, data)
    }

    @DeleteMapping("/{id}")
    fun delete(
        @RequestHeader(required = true) secretAccessKey: String,
        @PathVariable id: Long
    ): ResponseEntity<ResponseModel<Customer?>> {
        val validationFailure = validateHeaderAndPath(secretAccessKey, id)
        if (validationFailure != null) return validationFailure
        return super.delete(id)
    }

    fun validateHeaderAndPath(secretAccessKey: String, id: Long): ResponseEntity<ResponseModel<Customer?>>? {
        // 2 validations necessary
        // 1. Whether the secretAccessKey actually represents a real business
        // 2. Whether the customer exists/belongs to this business
        val business = businessRepository.findBusinessBySecretAccessKey(secretAccessKey)
            ?: return ResponseModel<Customer?>(
                data = null,
                message = "Invalid/Missing business secret access key"
            ).build(HttpStatus.FORBIDDEN)
        val customerResponse = super.get(id)
        if (customerResponse.body?.data?.businessId != business.id) {
            return ResponseModel<Customer?>(
                data = null,
                message = "Customer: $id does not exist for Business: ${business.id}"
            ).build(HttpStatus.FORBIDDEN)
        }
        return null
    }

}