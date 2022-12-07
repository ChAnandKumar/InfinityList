package com.example.infinitylist.data.model

import com.example.infinitylist.data.model.Book
import com.squareup.moshi.Json

data class Books(
    @Json(name = "kind") val kind: String? = null,
    @Json(name = "totalItems") val totalItems: Int = 0,
    @Json(name = "items") val items: List<Book> = arrayListOf()
)