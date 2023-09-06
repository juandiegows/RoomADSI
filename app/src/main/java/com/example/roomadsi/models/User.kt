package com.example.roomadsi.models

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.NO_ACTION
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.Date


@Entity(tableName = User.TABLE_NAME, foreignKeys = [
    ForeignKey(
        entity = Gender::class,
        parentColumns = [Gender.COL_ID],
        childColumns = [User.COL_GENDER_ID],
        onDelete = NO_ACTION,
        onUpdate = NO_ACTION
    ),
],
    indices = [Index(value = ["email"], unique = true)]
    )
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(COL_ID) var id:Long,
    @ColumnInfo(name = COL_NAME) var name:String,
    @ColumnInfo(name = COL_LAST_NAME) var lastName:String,
    @ColumnInfo(name = COL_EMAIL) var email: String,
    @ColumnInfo(name = COL_BIRTH_DAY) var birthday: String,
    @ColumnInfo(name = COL_GENDER_ID) var genderId:Long,
) {
    companion object {
        const val TABLE_NAME = "user"
        const val COL_ID = "id"
        const val  COL_NAME = "name"
        const val  COL_LAST_NAME = "last_name"
        const val  COL_EMAIL = "email"
        const val  COL_BIRTH_DAY = "birthday"
        const val  COL_GENDER_ID = "gender_id"
    }
}