package com.example.roomadsi.database

import android.content.ContentValues
import android.content.Context
import androidx.room.Database
import androidx.room.OnConflictStrategy
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.roomadsi.controller.GenderDAO
import com.example.roomadsi.controller.UserDAO
import com.example.roomadsi.models.Gender
import com.example.roomadsi.models.User


@Database(entities = [Gender::class, User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    //se crear los controlladores
    abstract fun genderDAO(): GenderDAO
    abstract fun userDAO(): UserDAO
    companion object {
        const val databaseName = "DBTest"

        @Volatile
        private var INSTANCIA: AppDatabase? = null

        fun GetDataBase(context: Context): AppDatabase {
            if (INSTANCIA != null) {
                return INSTANCIA!!
            }

            INSTANCIA = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                databaseName
            ).addCallback(object : Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    var list = listOf(
                        Gender(0, "Femenino"),
                        Gender(0, "Masculino")
                    )
                    list.forEach { gender ->
                        db.insert(
                            Gender.TABLE_NAME,
                            OnConflictStrategy.ABORT,
                            ContentValues().apply {
                                put(Gender.COL_NAME, gender.name)
                            })
                    }

                }
            }).build()
            return INSTANCIA!!

        }
    }

}


