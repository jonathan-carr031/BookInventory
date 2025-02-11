package com.example.bookinventoryapp.book.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IndustryIdentifierDto(
    @SerialName("type") val type: String,
    @SerialName("identifier") val identifier: String
)
