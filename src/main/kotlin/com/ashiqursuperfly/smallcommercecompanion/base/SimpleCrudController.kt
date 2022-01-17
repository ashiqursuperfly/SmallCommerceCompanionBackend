package com.ashiqursuperfly.smallcommercecompanion.base

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

abstract class SimpleCrudController<ID : Any, MODEL: SimpleBaseModel<MODEL>, REPOSITORY : MongoRepository<MODEL, ID>>{

    abstract fun getCrudRepository(): REPOSITORY

    open fun get(id: ID): ResponseEntity<ResponseModel<MODEL?>> {
        val res = getCrudRepository().findById(id)
        return if (res.isPresent) {
            ResponseModel<MODEL?>(res.get()).build(HttpStatus.OK)
        }
        else ResponseModel<MODEL?>(data=null, message="Invalid Model ID: $id").build(HttpStatus.FORBIDDEN)
    }
    
    open fun post(data: MODEL): ResponseEntity<ResponseModel<MODEL?>> {
        val saved = getCrudRepository().save(data)
        return ResponseModel<MODEL?>(saved).build(HttpStatus.OK)
    }
    
    open fun put(id: ID, data: MODEL): ResponseEntity<ResponseModel<MODEL?>> {
        val res = getCrudRepository().findById(id)
        return if (res.isPresent) {
            return post(res.get().update(data))
        }
        else ResponseModel<MODEL?>(data=null, message="Invalid MODEL ID: $id").build(HttpStatus.FORBIDDEN)
    }

    open fun delete(id: ID): ResponseEntity<ResponseModel<MODEL?>> {
        return if (getCrudRepository().existsById(id)) {
            getCrudRepository().deleteById(id)
            ResponseModel<MODEL?>(data=null, message="Deletion Successful").build(HttpStatus.OK)
        } else ResponseModel<MODEL?>(data=null, message="Invalid MODEL ID: $id").build(HttpStatus.FORBIDDEN)
    }
}