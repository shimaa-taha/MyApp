package com.week6.openpdf.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.week6.openpdf.UserDoe
import com.week6.openpdf.models.userItem


@Database(entities = [userItem::class], version = 4)
abstract class UserDataBase : RoomDatabase() {


    abstract fun dao(): UserDoe
}



