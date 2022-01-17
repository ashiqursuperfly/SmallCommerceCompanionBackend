package com.ashiqursuperfly.smallcommercecompanion.models

import com.ashiqursuperfly.smallcommercecompanion.base.SimpleBaseModel
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = Const.Mongo.Collections.CUSTOMERS)
data class Customer(
    @Id
    var id: Long,
    var name: String?,

    var phoneNumber: String?,
    var email: String?,
    var facebookProfileLink: String?,
    var instagramProfileLink: String?,
    var businessId: Long?
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
