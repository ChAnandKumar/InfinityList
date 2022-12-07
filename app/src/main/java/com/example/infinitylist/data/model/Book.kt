package com.example.infinitylist.data.model

import com.example.infinitylist.data.model.SaleInfo
import com.example.infinitylist.data.model.SearchInfo
import com.example.infinitylist.data.model.VolumeInfo
import com.squareup.moshi.Json

data class Book(
    @Json(name = "kind") val kind: String? = null,
    @Json(name = "id") val id: String? = null,
    @Json(name = "etag") val etag: String? = null,
    @Json(name = "selfLink") val selfLink: String? = null,
    @Json(name = "volumeInfo") val volumeInfo: VolumeInfo? = VolumeInfo(),
    @Json(name = "saleInfo") val saleInfo: SaleInfo? = SaleInfo(),
    @Json(name = "accessInfo") val accessInfo: AccessInfo? = AccessInfo(),
    @Json(name = "searchInfo") val searchInfo: SearchInfo? = SearchInfo()
)