package com.example.asset.aalab4

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(News::class), version = 1)
abstract class ProjectDatabase: RoomDatabase() {
    abstract fun newsDao(): NewsDao
}