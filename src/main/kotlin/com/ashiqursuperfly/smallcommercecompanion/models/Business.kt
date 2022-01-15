package com.ashiqursuperfly.smallcommercecompanion.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection=Const.MongoCollections.BUSINESSES)
data class Business(
    @Id
    val id: String,
    @Field
    val name: String?,
    @Field
    val password: String?,
    @Field
    val phoneNumber: String?,
    @Field
    val email: String?,
    @Field
    val facebookPageLink: String?,
    @Field
    val instagramPageLink: String?,
    @Field
    val youtubePageLink: String?,
    @Field
    val about: String?
) : SimpleBaseModel<Business> {

    override fun update(data: Business): Business {
        //TODO:
        return this
    }

}
