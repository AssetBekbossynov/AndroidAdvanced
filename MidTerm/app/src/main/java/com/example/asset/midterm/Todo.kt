package com.example.asset.midterm

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity(foreignKeys = arrayOf(ForeignKey(entity = User::class, parentColumns = arrayOf("id"), childColumns = arrayOf("user_id"))))
data class Todo(@PrimaryKey var id: Long,
                var title: String,
                var description: String,
                var status: String,
                @ColumnInfo var user_id: Long) {

}