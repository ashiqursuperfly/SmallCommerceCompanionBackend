package com.ashiqursuperfly.smallcommercecompanion.models

interface SimpleBaseModel<T> {
    fun update(data: T): T
}