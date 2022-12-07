package com.example.infinitylist.data.model

import com.squareup.moshi.Json

data class SearchInfo (
  @Json(name ="textSnippet" ) val textSnippet : String? = null
)