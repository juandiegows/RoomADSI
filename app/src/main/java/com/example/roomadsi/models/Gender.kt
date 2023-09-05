package com.example.roomadsi.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.util.TableInfo

@Entity(tableName = Gender.TABLE_NAME, indices = [
   Index(value = ["name"], unique = true)
] )
data class Gender(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COL_ID) var id:Long,
    @ColumnInfo(name = COL_NAME) var name:String
) {
    companion object {
        const val TABLE_NAME = "gender"
        const val COL_ID = "id"
        const val  COL_NAME = "name"
    }

}