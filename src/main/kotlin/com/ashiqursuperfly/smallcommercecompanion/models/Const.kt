package com.ashiqursuperfly.smallcommercecompanion.models

import java.util.*

object Const {
    object Mongo {
        object Collections {
            const val BUSINESSES = "businesses"
            const val CUSTOMERS = "customers"
            const val ORDERS = "orders"
            const val PRODUCTS = "products"
        }
        object SEQUENCES {
            const val BUSINESS_SEQUENCE = "business_sequence"
            const val CUSTOMER_SEQUENCE = "customer_sequence"
            const val PRODUCT_SEQUENCE = "product_sequence"
        }
    }
}