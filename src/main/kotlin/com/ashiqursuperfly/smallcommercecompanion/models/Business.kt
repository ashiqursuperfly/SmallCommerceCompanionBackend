package com.ashiqursuperfly.smallcommercecompanion.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection=Const.MongoCollections.BUSINESSES)
data class Business(

    @Id
    val id: String, // TODO: Auto Increment
    @Field
    var name: String?,
    @Field
    var password: String?,
    @Field
    var phoneNumber: String?,
    @Field
    var email: String?,
    @Field
    var facebookPageLink: String?,
    @Field
    var instagramPageLink: String?,
    @Field
    var youtubePageLink: String?,
    @Field
    var about: String?
) : SimpleBaseModel<Business> {

    override fun update(data: Business): Business {
        data.name?.let {
            this.name = it
        }
        data.phoneNumber?.let {
            this.phoneNumber = it
        }
        data.email?.let {
            this.email = it
        }
        data.facebookPageLink?.let {
            this.facebookPageLink = it
        }
        data.instagramPageLink?.let {
            this.instagramPageLink = it
        }
        data.youtubePageLink?.let {
            this.youtubePageLink = it
        }
        data.about?.let {
            this.about = it
        }
        return this
    }

}
