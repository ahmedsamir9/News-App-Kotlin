package com.example.newstracker.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.newstracker.data.model.Article

import kotlinx.coroutines.flow.Flow

@Dao
interface SavedDao {
    @Insert
    suspend fun insert(article: List<Article>)
    @Delete
    suspend fun delete(article: Article)
    @Delete
    suspend fun deleteAll()
    @Query("select * from Article")
    suspend fun getAllSavedNews():Flow<List<Article>>
}