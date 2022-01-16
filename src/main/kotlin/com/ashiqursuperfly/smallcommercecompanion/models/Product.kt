package com.ashiqursuperfly.smallcommercecompanion.models

import com.ashiqursuperfly.smallcommercecompanion.base.SimpleBaseModel
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = Const.MongoCollections.PRODUCTS)
data class Product(
    @Field
    val id: String?,
    @Field
    var name: String?,
    @Field
    var description: String?,
    @DBRef
    var business: Business?
) : SimpleBaseModel<Product> {

    override fun update(data: Product): Product {
        data.name?.let {
            this.name = it
        }
        data.description?.let {
            this.description = it
        }
        data.business?.let {
            this.business = it
        }
        return this
    }
}
