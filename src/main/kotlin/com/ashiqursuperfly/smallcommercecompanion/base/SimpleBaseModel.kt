package com.ashiqursuperfly.smallcommercecompanion.base

interface SimpleBaseModel<T> {
    fun update(data: T): T
}