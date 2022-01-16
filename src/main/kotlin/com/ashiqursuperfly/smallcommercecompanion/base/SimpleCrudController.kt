package com.ashiqursuperfly.smallcommercecompanion.base

import com.ashiqursuperfly.smallcommercecompanion.controllers.ResponseModel
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

abstract class SimpleCrudController<MODEL: SimpleBaseModel<MODEL>, REPOSITORY : MongoRepository<MODEL, String>>{

    abstract fun getRepository(): REPOSITORY

    open fun get(id: String): ResponseEntity<ResponseModel<MODEL?>> {
        val res = getRepository().findById(id)
        return if (res.isPresent) {
            ResponseModel<MODEL?>(res.get()).build(HttpStatus.OK)
        }
        else ResponseModel<MODEL?>(data=null, message="Invalid Model ID: $id").build(HttpStatus.FORBIDDEN)
    }
    
    open fun post(data: MODEL): ResponseEntity<ResponseModel<MODEL?>> {
        val saved = getRepository().save(data)
        return ResponseModel<MODEL?>(saved).build(HttpStatus.OK)
    }
    
    open fun put(id: String, data: MODEL): ResponseEntity<ResponseModel<MODEL?>> {
        val res = getRepository().findById(id)
        return if (res.isPresent) {
            ResponseModel<MODEL?>(res.get().update(data)).build(HttpStatus.OK)
        }
        else ResponseModel<MODEL?>(data=null, message="Invalid MODEL ID: $id").build(HttpStatus.FORBIDDEN)
    }

    //TODO: delete
}