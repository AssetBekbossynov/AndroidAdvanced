package com.example.asset.midterm

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTodo(todo: Todo): Long?

    @Query("SELECT * FROM todo Where user_id = :userId")
    fun getTodosByUserId(userId: Long): List<Todo>

    @Query("SELECT * FROM todo Where user_id = :userId and status = :status")
    fun getTodosByStatusAndUser(userId: Long, status: String): List<Todo>

    @Query("SELECT COUNT(id) FROM todo")
    fun getCount(): Long
}