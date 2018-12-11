package com.example.asset.midterm

import android.content.Context

interface Communicator {
    fun getUser(userId: Long, context: Context)
}