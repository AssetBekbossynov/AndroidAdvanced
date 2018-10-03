package com.example.asset.aalab4

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable

@Entity
data class News (
        @PrimaryKey
        var id: Long,
        var title: String,
        var date: String,
        var content: String){

}