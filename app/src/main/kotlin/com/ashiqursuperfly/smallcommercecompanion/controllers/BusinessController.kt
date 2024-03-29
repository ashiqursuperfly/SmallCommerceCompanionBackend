package com.ashiqursuperfly.smallcommercecompanion.controllers

import com.ashiqursuperfly.smallcommercecompanion.base.ResponseModel
import com.ashiqursuperfly.smallcommercecompanion.base.SimpleCrudController
import com.ashiqursuperfly.smallcommercecompanion.models.Business
import com.ashiqursuperfly.smallcommercecompanion.models.Const
import com.ashiqursuperfly.smallcommercecompanion.repositories.BusinessRepository
import com.ashiqursuperfly.smallcommercecompanion.repositories.CustomerRepository
import com.ashiqursuperfly.smallcommercecompanion.repositories.OrderRepository
import com.ashiqursuperfly.smallcommercecompanion.repositories.ProductRepository
import com.ashiqursuperfly.smallcommercecompanion.services.SequenceGeneratorService
import com.ashiqursuperfly.smallcommercecompanion.utils.Utils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DuplicateKeyException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("api/v1/business")
class BusinessController : SimpleCrudController<Long, Business, BusinessRepository>() {

    @Autowired
    lateinit var sequenceGenerator: SequenceGeneratorService

    @Autowired
    lateinit var businessRepository: BusinessRepository

    @Autowired
    lateinit var customerRepository: CustomerRepository

    @Autowired
    lateinit var productRepository: ProductRepository

    @Autowired
    lateinit var orderRepository: OrderRepository

    override fun getCrudRepository(): BusinessRepository {
        return businessRepository
    }

    @GetMapping("/{id}")
    fun get(@RequestHeader(required = true) secretAccessKey: String, @PathVariable id: Long): ResponseEntity<ResponseModel<Business?>> {
        val validationFailure = validationFailure(secretAccessKey, id)
        if (validationFailure != null) return validationFailure

        return super.get(id)
    }

    @PostMapping
    override fun post(@RequestBody data: Business): ResponseEntity<ResponseModel<Business?>> {
        if (data.contactInfoInvalid()) {
            return ResponseModel<Business?>(
                data = null,
                message = "Please provide either a valid email or a valid phone number or both"
            ).build(HttpStatus.BAD_REQUEST)
        }

        val copied = data.copy(
            id = sequenceGenerator.generateSequence(Const.Mongo.SEQUENCES.BUSINESS_SEQUENCE)
        )
        copied.secretAccessKey = Utils.generateSHA1(copied.toString())

        return try {
            super.post(copied)
        } catch (ex: DuplicateKeyException) {
            ResponseModel<Business?>(
                data = null,
                message = "A business \"${data.name}\" already exists. Please choose an unique business name"
            ).build(HttpStatus.BAD_REQUEST)
        }

    }

    @PutMapping("/{id}")
    fun put(
        @RequestHeader(required = true) secretAccessKey: String,
        @PathVariable id: Long,
        @RequestBody data: Business
    ): ResponseEntity<ResponseModel<Business?>> {
        val validationFailure = validationFailure(secretAccessKey, id)
        if (validationFailure != null) return validationFailure

        return super.post(getCrudRepository().findById(id).get().update(data))
    }

    @DeleteMapping("/{id}")
    fun delete(
        @RequestHeader(required = true) secretAccessKey: String,
        @PathVariable id: Long
    ): ResponseEntity<ResponseModel<Business?>> {
        val validationFailure = validationFailure(secretAccessKey, id)
        if (validationFailure != null) return validationFailure
        getCrudRepository().deleteById(id)
        customerRepository.deleteAll(customerRepository.findAllCustomersOfThisBusiness(id))
        productRepository.deleteAll(productRepository.findAllProductsOfThisBusiness(id))
        orderRepository.deleteAll(orderRepository.findAllOrdersOfThisBusiness(id))

        return ResponseModel<Business?>(data = null, message = "Deletion Successful").build(HttpStatus.OK)
    }

    fun validationFailure(secretAccessKey: String, id: Long): ResponseEntity<ResponseModel<Business?>>? {
        val res = getCrudRepository().findById(id)
        if (res.isEmpty) {
            return ResponseModel<Business?>(data = null, message = "Invalid MODEL ID: $id").build(HttpStatus.FORBIDDEN)
        }
        if (res.get().secretAccessKey != secretAccessKey) {
            return ResponseModel<Business?>(
                data = null,
                message = "Invalid/Missing business secret access key"
            ).build(HttpStatus.FORBIDDEN)
        }
        return null
    }
}