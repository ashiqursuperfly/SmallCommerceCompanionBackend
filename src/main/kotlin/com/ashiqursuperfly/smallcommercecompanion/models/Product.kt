package com.ashiqursuperfly.smallcommercecompanion.models

import com.ashiqursuperfly.smallcommercecompanion.base.SimpleBaseModel
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = Const.Mongo.Collections.PRODUCTS)
data class Product(
    @Id
    val id: String?,
    var name: String?,
    var description: String?,
    var businessId: Long?
) : SimpleBaseModel<Product> {

    override fun update(data: Product): Product {
        data.name?.let {
            this.name = it
        }
        data.description?.let {
            this.description = it
        }
        return this
    }
}
