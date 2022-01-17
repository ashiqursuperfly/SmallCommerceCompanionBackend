package com.ashiqursuperfly.smallcommercecompanion.repositories

import com.ashiqursuperfly.smallcommercecompanion.models.Const
import com.ashiqursuperfly.smallcommercecompanion.models.Customer
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: MongoRepository<Customer, Long> {
    @Query("{'${Const.Mongo.Params.BUSINESS_ID}' : ?0}")
    fun findAllCustomersOfThisBusiness(businessId: Long): List<Customer>
}