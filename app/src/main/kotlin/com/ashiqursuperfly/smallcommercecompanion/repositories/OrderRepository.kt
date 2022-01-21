package com.ashiqursuperfly.smallcommercecompanion.repositories

import com.ashiqursuperfly.smallcommercecompanion.models.Const
import com.ashiqursuperfly.smallcommercecompanion.models.Order
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface OrderRepository : MongoRepository<Order, Long> {
    @Query("{'${Const.Mongo.Params.BUSINESS_ID}' : ?0}")
    fun findAllOrdersOfThisBusiness(id: Long): List<Order>
}