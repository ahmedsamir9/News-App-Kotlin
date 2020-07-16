package com.example.newstracker.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newstracker.data.model.Article
import com.example.newstracker.data.model.FavoriteNews


@Database(entities = [FavoriteNews::class],version = 1,exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun savedDoa(): SavedDao
    abstract fun favoriteDao(): FavoriteDoa

}