package com.ashiqursuperfly.smallcommercecompanion.models

import com.ashiqursuperfly.smallcommercecompanion.base.SimpleBaseModel
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = Const.Mongo.Collections.PRODUCTS)
data class Product(
    @Id
    val id: Long,
    var name: String?,
    var description: String?,
    var price: Float,
    var businessId: Long
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Product

        if (id != other.id) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + (name?.hashCode() ?: 0)
        return result
    }


}
