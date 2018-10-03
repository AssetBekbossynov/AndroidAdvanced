package com.example.asset.aalab4

import android.app.Application
import android.arch.persistence.room.Room

class MyApp: Application() {

    lateinit var database: ProjectDatabase

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(applicationContext,
                ProjectDatabase::class.java,
                "ProjectDatabase")
                .fallbackToDestructiveMigration()
                .build()
    }
}