package com.example.roomadsi.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomadsi.controller.GenderDao
import com.example.roomadsi.controller.UserDAO
import com.example.roomadsi.models.Gender
import com.example.roomadsi.models.User


@Database(entities = [Gender::class, User::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    //se crear los controlladores
    abstract  fun genderDAO(): GenderDao
//    abstract  fun userDAO(): UserDAO
    companion object {
        @Volatile
        private var INSTANCIA: AppDatabase? = null

        fun GetDataBase(context: Context): AppDatabase {
            if (INSTANCIA != null) {
                return INSTANCIA!!
            }

            INSTANCIA = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "DBTest"
            ).build()
            return INSTANCIA!!

        }
    }

}


