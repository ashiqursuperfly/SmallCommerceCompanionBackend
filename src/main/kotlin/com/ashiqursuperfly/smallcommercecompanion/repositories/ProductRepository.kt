package com.ashiqursuperfly.smallcommercecompanion.repositories

import com.ashiqursuperfly.smallcommercecompanion.models.Product
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: MongoRepository<Product, String> {
}