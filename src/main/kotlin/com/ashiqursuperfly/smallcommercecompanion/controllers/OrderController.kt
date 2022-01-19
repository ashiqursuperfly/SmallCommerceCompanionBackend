package com.ashiqursuperfly.smallcommercecompanion.controllers

import com.ashiqursuperfly.smallcommercecompanion.base.ResponseModel
import com.ashiqursuperfly.smallcommercecompanion.base.SimpleCrudController
import com.ashiqursuperfly.smallcommercecompanion.models.Const
import com.ashiqursuperfly.smallcommercecompanion.models.Order
import com.ashiqursuperfly.smallcommercecompanion.repositories.BusinessRepository
import com.ashiqursuperfly.smallcommercecompanion.repositories.CustomerRepository
import com.ashiqursuperfly.smallcommercecompanion.repositories.OrderRepository
import com.ashiqursuperfly.smallcommercecompanion.services.SequenceGeneratorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.ZonedDateTime

@RestController
@RequestMapping("api/v1/order")
class OrderController : SimpleCrudController<Long, Order, OrderRepository>() {
    @Autowired
    lateinit var sequenceGenerator: SequenceGeneratorService

    @Autowired
    lateinit var orderRepository: OrderRepository

    @Autowired
    lateinit var customerRepository: CustomerRepository

    @Autowired
    lateinit var businessRepository: BusinessRepository

    override fun getCrudRepository(): OrderRepository {
        return orderRepository
    }

    @GetMapping("/{id}")
    fun get(
        @RequestHeader(required = true) secretAccessKey: String,
        @PathVariable id: Long
    ): ResponseEntity<ResponseModel<Order?>> {
        val validationFailure = validateHeaderAndPath(secretAccessKey, id)
        if (validationFailure != null) return validationFailure
        return super.get(id)
    }

    @GetMapping
    fun getAll(@RequestHeader(required = true) secretAccessKey: String): ResponseEntity<ResponseModel<List<Order>?>> {
        val business = businessRepository.findBusinessBySecretAccessKey(secretAccessKey)
            ?: return ResponseModel<List<Order>?>(
                data = null,
                message = "Invalid/Missing business secret access key"
            ).build(HttpStatus.FORBIDDEN)

        val orders = orderRepository.findAllOrdersOfThisBusiness(business.id)

        return ResponseModel<List<Order>?>(data = orders).build(HttpStatus.OK)
    }


    @PostMapping
    fun post(
        @RequestHeader(required = true) secretAccessKey: String,
        @RequestBody data: Order
    ): ResponseEntity<ResponseModel<Order?>> {
        val business = businessRepository.findBusinessBySecretAccessKey(secretAccessKey)
            ?: return ResponseModel<Order?>(
                data = null,
                message = "Invalid/Missing business secret access key"
            ).build(HttpStatus.FORBIDDEN)
        // TODO: validate if the entered customer/products are actually owned by this business
        val customer = customerRepository.findById(data.customer.id)
        val copied = data.copy(
            id = sequenceGenerator.generateSequence(Const.Mongo.SEQUENCES.PRODUCT_SEQUENCE),
            businessId = business.id,
            dateCreated = ZonedDateTime.now().toEpochSecond()
        )
        return super.post(copied)
    }

    @PutMapping("/{id}")
    fun put(
        @RequestHeader(required = true) secretAccessKey: String,
        @RequestBody data: Order,
        @PathVariable id: Long
    ): ResponseEntity<ResponseModel<Order?>> {
        val validationFailure = validateHeaderAndPath(secretAccessKey, id)
        if (validationFailure != null) return validationFailure
        return super.put(id, data)
    }

    @DeleteMapping("/{id}")
    fun delete(
        @RequestHeader(required = true) secretAccessKey: String,
        @PathVariable id: Long
    ): ResponseEntity<ResponseModel<Order?>> {
        val validationFailure = validateHeaderAndPath(secretAccessKey, id)
        if (validationFailure != null) return validationFailure
        return super.delete(id)
    }

    fun validateHeaderAndPath(secretAccessKey: String, id: Long): ResponseEntity<ResponseModel<Order?>>? {
        // 2 validations necessary
        // 1. Whether the secretAccessKey actually represents a real business
        // 2. Whether the order exists/belongs to this business
        val business = businessRepository.findBusinessBySecretAccessKey(secretAccessKey)
            ?: return ResponseModel<Order?>(
                data = null,
                message = "Invalid/Missing business secret access key"
            ).build(HttpStatus.FORBIDDEN)
        val orderResponse = super.get(id)
        if (orderResponse.body?.data?.businessId != business.id) {
            return ResponseModel<Order?>(
                data = null,
                message = "This is not a order of this business: ${business.id}"
            ).build(HttpStatus.FORBIDDEN)
        }
        return null
    }
}