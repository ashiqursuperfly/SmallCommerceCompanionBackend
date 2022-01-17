package com.ashiqursuperfly.smallcommercecompanion.controllers

import com.ashiqursuperfly.smallcommercecompanion.base.ResponseModel
import com.ashiqursuperfly.smallcommercecompanion.base.SimpleCrudController
import com.ashiqursuperfly.smallcommercecompanion.models.Business
import com.ashiqursuperfly.smallcommercecompanion.models.Const
import com.ashiqursuperfly.smallcommercecompanion.repositories.BusinessRepository
import com.ashiqursuperfly.smallcommercecompanion.services.SequenceGeneratorService
import com.ashiqursuperfly.smallcommercecompanion.utils.Utils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("api/v1/business")
class BusinessController: SimpleCrudController<Long, Business, BusinessRepository>() {

    @Autowired
    lateinit var sequenceGenerator: SequenceGeneratorService

    @Autowired
    lateinit var businessRepository: BusinessRepository

    override fun getRepository(): BusinessRepository {
        return businessRepository
    }

    @GetMapping("/{id}")
    override fun get(@PathVariable id: Long): ResponseEntity<ResponseModel<Business?>> {
        return super.get(id)
    }

    @PostMapping
    override fun post(@RequestBody data: Business): ResponseEntity<ResponseModel<Business?>> {
        val copied = data.copy(
            id=sequenceGenerator.generateSequence(Const.Mongo.SEQUENCES.BUSINESS_SEQUENCE)
        )
        copied.secretAccessKey = Utils.generateSHA1(copied.toString())
        return super.post(copied)
    }

    @PutMapping("/{id}")
    fun put(@RequestHeader(required = true) secretAccessKey: String, @PathVariable id: Long, @RequestBody data: Business): ResponseEntity<ResponseModel<Business?>> {
        val res = getRepository().findById(id)
        if (res.isPresent) {
            return if (res.get().secretAccessKey == secretAccessKey) {
                super.post(res.get().update(data))
            } else ResponseModel<Business?>(data=null, message="Invalid/Missing business secret access key").build(HttpStatus.FORBIDDEN)
        }
        return ResponseModel<Business?>(data=null, message="Invalid MODEL ID: $id").build(HttpStatus.FORBIDDEN)
    }

}