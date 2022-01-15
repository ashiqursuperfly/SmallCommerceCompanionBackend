package com.ashiqursuperfly.smallcommercecompanion.controllers

import com.ashiqursuperfly.smallcommercecompanion.models.ResponseModel
import com.ashiqursuperfly.smallcommercecompanion.models.SimpleBaseModel
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

abstract class SimpleCrudController<MODEL: SimpleBaseModel<MODEL>, REPOSITORY : MongoRepository<MODEL, String>>{

    private lateinit var repository: REPOSITORY

    open fun get(id: String): ResponseEntity<ResponseModel<MODEL?>> {
        val res = repository.findById(id)
        return if (res.isPresent) {
            ResponseModel<MODEL?>(res.get()).build(HttpStatus.OK)
        }
        else ResponseModel<MODEL?>(data=null, detail="Invalid Model ID: $id").build(HttpStatus.FORBIDDEN)
    }
    
    open fun post(data: MODEL): ResponseEntity<ResponseModel<MODEL?>> {
        val saved = repository.save(data)
        return ResponseModel<MODEL?>(saved).build(HttpStatus.OK)
    }
    
    open fun put(id: String, data: MODEL): ResponseEntity<ResponseModel<MODEL?>> {
        val res = repository.findById(id)
        return if (res.isPresent) {
            ResponseModel<MODEL?>(res.get().update(data)).build(HttpStatus.OK)
        }
        else ResponseModel<MODEL?>(data=null, detail="Invalid MODEL ID: $id").build(HttpStatus.FORBIDDEN)
    }
}