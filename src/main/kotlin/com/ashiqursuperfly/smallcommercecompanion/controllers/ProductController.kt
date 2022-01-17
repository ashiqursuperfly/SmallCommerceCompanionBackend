package com.ashiqursuperfly.smallcommercecompanion.controllers

import com.ashiqursuperfly.smallcommercecompanion.base.ResponseModel
import com.ashiqursuperfly.smallcommercecompanion.base.SimpleCrudController
import com.ashiqursuperfly.smallcommercecompanion.models.Product
import com.ashiqursuperfly.smallcommercecompanion.repositories.BusinessRepository
import com.ashiqursuperfly.smallcommercecompanion.repositories.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ProductController: SimpleCrudController<Long, Product, ProductRepository>() {

    @Autowired
    lateinit var productRepository: ProductRepository

    @Autowired
    lateinit var businessRepository: BusinessRepository

    override fun getRepository(): ProductRepository {
        return productRepository
    }

    @GetMapping("products/{id}")
    override fun get(@PathVariable id: Long): ResponseEntity<ResponseModel<Product?>> {
        return super.get(id)
    }

    @PostMapping("/products")
    fun post(@RequestBody data: Product, @RequestParam(required = true) businessID: Long): ResponseEntity<ResponseModel<Product?>> {
        val business = businessRepository.findById(businessID)
        if (business.isEmpty) {
            return ResponseModel<Product?>(data=null, message="Invalid Business ID: $businessID").build(HttpStatus.FORBIDDEN)
        }
        val copied = data.copy(businessId = business.get().id)
        return super.post(copied)
    }


    @PutMapping("products/{id}")
    override fun put(id: Long, data: Product): ResponseEntity<ResponseModel<Product?>> {
        return super.put(id, data)
    }
}