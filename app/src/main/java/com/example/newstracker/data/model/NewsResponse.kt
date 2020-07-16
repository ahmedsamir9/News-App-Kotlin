package com.example.newstracker.data.model


import com.squareup.moshi.Json

data class NewsResponse(
    @Json(name = "articles")
     public val articles: List<Article>?,
    @Json(name = "status")
    val status: String?,
    @Json(name = "totalResults")
    val totalResults: Int?
)