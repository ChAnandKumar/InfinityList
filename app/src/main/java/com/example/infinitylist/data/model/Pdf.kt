package com.example.infinitylist.data.model

import com.squareup.moshi.Json

data class Pdf(
    @Json(name = "isAvailable") val isAvailable: Boolean? = null
)