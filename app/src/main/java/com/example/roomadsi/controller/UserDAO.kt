package com.example.roomadsi.controller

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.roomadsi.models.User

@Dao
interface UserDAO
{
    @Insert
    fun insert(user: User) : Long
    @Query("SELECT * FROM ${User.TABLE_NAME}")
     fun get(): List<User>
    @Query("SELECT * FROM ${User.TABLE_NAME} WHERE ${User.COL_ID} = :userId")
    suspend fun get(userId: Long): User?

    @Update
    fun update(user: User)
    @Delete
    fun delete(user: User)
}