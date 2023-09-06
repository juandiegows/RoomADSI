package com.example.roomadsi.controller

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.roomadsi.models.Gender

@Dao
interface GenderDao {

    @Insert
    fun insert(gender: Gender) : Long
    @Query("SELECT * FROM ${Gender.TABLE_NAME}")
     fun get(): List<Gender>
    @Query("SELECT * FROM ${Gender.TABLE_NAME} WHERE ${Gender.COL_ID} = :genderId")
     fun get(genderId: Long): Gender?

    @Update
    fun update(gender: Gender)

    @Delete
    fun delete(gender: Gender)


}

