package com.ashiqursuperfly.smallcommercecompanion.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "database_sequences")
data class DatabaseSequence (
    @Id
    var id: String? = null,
    var seq: Long = 0,
)