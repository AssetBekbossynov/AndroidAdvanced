package com.example.asset.aalab4

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNews(news: News): Long?

    @Query("SELECT * FROM news")
    fun getNews(): List<News>

    @Query("SELECT COUNT(id) FROM news")
    fun getCount(): Long
}