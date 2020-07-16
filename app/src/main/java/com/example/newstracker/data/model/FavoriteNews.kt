package com.example.newstracker.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoriteNews(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
@ColumnInfo
    val title :String?,
    @ColumnInfo
    val ImageUrl:String?,
    @ColumnInfo
    val siteUrl:String
) {
}