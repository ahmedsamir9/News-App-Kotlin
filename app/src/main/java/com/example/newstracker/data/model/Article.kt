package com.example.newstracker.data.model
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity
public data class Article(

    @Json(name = "author")
    val author: String?,

    @Json(name = "content")
    val content: String?,

    @Json(name = "description")
    val description: String?,

    @Json(name = "publishedAt")
    val publishedAt: String?,

    @Json(name = "source")
    val source: Source?,
    @PrimaryKey
    @Json(name = "title")
    val title: String?,

    @Json(name = "url")
    val url: String?,

    @Json(name = "urlToImage")
    val urlToImage: String?
)