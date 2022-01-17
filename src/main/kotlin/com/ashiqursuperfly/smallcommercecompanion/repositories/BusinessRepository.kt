package com.ashiqursuperfly.smallcommercecompanion.repositories

import com.ashiqursuperfly.smallcommercecompanion.models.Business
import com.ashiqursuperfly.smallcommercecompanion.models.Const
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface BusinessRepository: MongoRepository<Business, Long> {
    @Query("{'${Const.Mongo.Params.SECRET_ACCESS_KEY}' : ?0}")
    fun findBusinessBySecretAccessKey(secretAccessKey: String): Business?
}