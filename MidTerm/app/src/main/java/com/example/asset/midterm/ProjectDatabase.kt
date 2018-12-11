package com.example.asset.midterm

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(User::class, Todo::class), version = 2)
abstract class ProjectDatabase: RoomDatabase() {
    abstract fun todoDao(): TodoDao
    abstract fun userDao(): UserDao
}