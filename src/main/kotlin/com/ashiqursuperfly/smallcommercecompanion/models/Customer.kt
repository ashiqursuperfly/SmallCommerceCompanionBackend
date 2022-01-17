package com.ashiqursuperfly.smallcommercecompanion.models

import com.ashiqursuperfly.smallcommercecompanion.base.SimpleBaseModel
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = Const.MongoCollections.CUSTOMERS)
data class Customer(
    @Id
    val id: String, // TODO: Auto Increment
    @Field
    var name: String?,
    @Field
    var phoneNumber: String?,
    @Field
    var email: String?,
    @Field
    var facebookProfileLink: String?,
    @Field
    var instagramProfileLink: String?,
    @DBRef
    var business: Business?
) : SimpleBaseModel<Customer> {

    override fun update(data: Customer): Customer {
        data.name?.let {
            this.name = it
        }
        data.phoneNumber?.let {
            this.phoneNumber = it
        }
        data.email?.let {
            this.email = it
        }
        data.facebookProfileLink?.let {
            this.facebookProfileLink = it
        }
        data.instagramProfileLink?.let {
            this.instagramProfileLink = it
        }
        return this
    }

}
