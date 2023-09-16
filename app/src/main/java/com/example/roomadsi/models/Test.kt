package com.example.roomadsi.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


class Test {
    var name : String = ""
}

@Entity
data  class Test2(
    @PrimaryKey(autoGenerate = true)
    var id : Int ,
    @ColumnInfo
    var name : String) {

}