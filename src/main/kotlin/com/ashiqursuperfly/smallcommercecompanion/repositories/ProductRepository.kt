package com.ashiqursuperfly.smallcommercecompanion.repositories

import com.ashiqursuperfly.smallcommercecompanion.models.Const
import com.ashiqursuperfly.smallcommercecompanion.models.Product
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: MongoRepository<Product, Long> {
    @Query("{'${Const.Mongo.Params.BUSINESS_ID}' : ?0}")
    fun findAllProductsOfThisBusiness(id: Long): List<Product>
}