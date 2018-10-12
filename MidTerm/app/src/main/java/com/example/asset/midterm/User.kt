package com.example.asset.midterm

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity
data class User (@PrimaryKey var id: Long,
                 var name: String,
                 var password: String){
    override fun toString(): String {
        return "User(id=$id, name='$name', password='$password')"
    }
}