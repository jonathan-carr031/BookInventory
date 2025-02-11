package com.example.bookinventoryapp.book.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class VolumeInfo(
    val title: String,
    val authors: List<String>,
    val publisher: String
)
