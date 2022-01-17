package com.ashiqursuperfly.smallcommercecompanion.models

import com.ashiqursuperfly.smallcommercecompanion.base.SimpleBaseModel
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection=Const.Mongo.Collections.BUSINESSES)
data class Business(
    @Id
    var id: Long,

    @Indexed(unique = true)
    var name: String?,
    @Indexed(unique = true)
    var secretAccessKey: String?,

    var phoneNumber: String?,
    var email: String?,

    var facebookPageLink: String?,
    var instagramPageLink: String?,
    var youtubePageLink: String?,
    var about: String?
) : SimpleBaseModel<Business> {

    override fun update(data: Business): Business {
        data.name?.let {
            this.name = it
        }
        data.phoneNumber?.let {
            this.phoneNumber = it
        }
        data.email?.let {
            this.email = it
        }
        data.facebookPageLink?.let {
            this.facebookPageLink = it
        }
        data.instagramPageLink?.let {
            this.instagramPageLink = it
        }
        data.youtubePageLink?.let {
            this.youtubePageLink = it
        }
        data.about?.let {
            this.about = it
        }
        return this
    }

}
