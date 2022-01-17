package com.ashiqursuperfly.smallcommercecompanion.controllers

import com.ashiqursuperfly.smallcommercecompanion.base.ResponseModel
import com.ashiqursuperfly.smallcommercecompanion.base.SimpleCrudController
import com.ashiqursuperfly.smallcommercecompanion.models.Const
import com.ashiqursuperfly.smallcommercecompanion.models.Product
import com.ashiqursuperfly.smallcommercecompanion.repositories.BusinessRepository
import com.ashiqursuperfly.smallcommercecompanion.repositories.ProductRepository
import com.ashiqursuperfly.smallcommercecompanion.services.SequenceGeneratorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/product")
class ProductController: SimpleCrudController<Long, Product, ProductRepository>() {

    @Autowired
    lateinit var sequenceGenerator: SequenceGeneratorService

    @Autowired
    lateinit var productRepository: ProductRepository

    @Autowired
    lateinit var businessRepository: BusinessRepository

    override fun getCrudRepository(): ProductRepository {
        return productRepository
    }

    @GetMapping("/{id}")
    fun get(
        @RequestHeader(required = true) secretAccessKey: String,
        @PathVariable id: Long
    ): ResponseEntity<ResponseModel<Product?>> {
        val validationFailure = validateHeaderAndPath(secretAccessKey, id)
        if (validationFailure != null) return validationFailure
        return super.get(id)
    }

    @GetMapping
    fun getAll(@RequestHeader(required = true) secretAccessKey: String): ResponseEntity<ResponseModel<List<Product>?>> {
        val business = businessRepository.findBusinessBySecretAccessKey(secretAccessKey)
            ?: return ResponseModel<List<Product>?>(
                data = null,
                message = "Invalid/Missing business secret access key"
            ).build(HttpStatus.FORBIDDEN)

        val products = productRepository.findAllProductsOfThisBusiness(business.id)

        return ResponseModel<List<Product>?>(data = products).build(HttpStatus.OK)
    }


    @PostMapping
    fun post(
        @RequestHeader(required = true) secretAccessKey: String,
        @RequestBody data: Product
    ): ResponseEntity<ResponseModel<Product?>> {
        val business = businessRepository.findBusinessBySecretAccessKey(secretAccessKey)
            ?: return ResponseModel<Product?>(
                data = null,
                message = "Invalid/Missing business secret access key"
            ).build(HttpStatus.FORBIDDEN)

        val copied = data.copy(
            id = sequenceGenerator.generateSequence(Const.Mongo.SEQUENCES.PRODUCT_SEQUENCE),
            businessId = business.id
        )
        return super.post(copied)
    }

    @PutMapping("/{id}")
    fun put(
        @RequestHeader(required = true) secretAccessKey: String,
        @RequestBody data: Product,
        @PathVariable id: Long
    ): ResponseEntity<ResponseModel<Product?>> {
        val validationFailure = validateHeaderAndPath(secretAccessKey, id)
        if (validationFailure != null) return validationFailure
        return super.put(id, data)
    }

    @DeleteMapping("/{id}")
    fun delete(
        @RequestHeader(required = true) secretAccessKey: String,
        @PathVariable id: Long
    ): ResponseEntity<ResponseModel<Product?>> {
        val validationFailure = validateHeaderAndPath(secretAccessKey, id)
        if (validationFailure != null) return validationFailure
        return super.delete(id)
    }

    fun validateHeaderAndPath(secretAccessKey: String, id: Long): ResponseEntity<ResponseModel<Product?>>? {
        // 2 validations necessary
        // 1. Whether the secretAccessKey actually represents a real business
        // 2. Whether the product exists/belongs to this business
        val business = businessRepository.findBusinessBySecretAccessKey(secretAccessKey)
            ?: return ResponseModel<Product?>(
                data = null,
                message = "Invalid/Missing business secret access key"
            ).build(HttpStatus.FORBIDDEN)
        val productResponse = super.get(id)
        if (productResponse.body?.data?.businessId != business.id) {
            return ResponseModel<Product?>(
                data = null,
                message = "This is not a product of this business: ${business.id}"
            ).build(HttpStatus.FORBIDDEN)
        }
        return null
    }
}