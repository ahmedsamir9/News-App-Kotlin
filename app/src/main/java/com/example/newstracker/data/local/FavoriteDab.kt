package com.example.newstracker.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.newstracker.data.model.FavoriteNews


import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDoa {
    @Insert
    suspend fun insert(article: FavoriteNews)
    @Delete
    suspend fun delete(article:FavoriteNews)
    @Query("select * from FavoriteNews")
    suspend fun getAllFavoirateNews():Flow<List<FavoriteNews>>
}