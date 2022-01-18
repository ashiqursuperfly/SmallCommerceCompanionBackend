package com.ashiqursuperfly.smallcommercecompanion.models

import com.ashiqursuperfly.smallcommercecompanion.base.SimpleBaseModel
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = Const.Mongo.Collections.ORDERS)
data class Order (
    @Id
    var id: Long,
    @DBRef
    var customer: Customer,
    @DBRef
    var products: List<Product>?,
    var instructions: String?,
    var deliveryAddress: String?,
    var dateCreated: Long?,
    var businessId: Long,
    var orderStatus: OrderStatus = OrderStatus.RECEIVED
) : SimpleBaseModel<Order> {

    override fun update(data: Order): Order {
        data.deliveryAddress?.let {
            deliveryAddress = it
        }
        data.instructions?.let {
            instructions = it
        }
        data.dateCreated?.let {
            dateCreated = it
        }
        data.products?.let {

        }
        return this
    }

    enum class OrderStatus {
        RECEIVED, CANCELLED, DELIVERED
    }

}
