package com.ashiqursuperfly.smallcommercecompanion.repositories

import com.ashiqursuperfly.smallcommercecompanion.models.Customer
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: MongoRepository<Customer, String> {
}