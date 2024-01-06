//package com.week6.openpdf
//
//import androidx.room.ColumnInfo
//import androidx.room.Entity
//import androidx.room.PrimaryKey
//
//@Entity(tableName = "user_data")
//data class userItem(
//    @PrimaryKey(autoGenerate = true)val id:Int=0,
//    @ColumnInfo(name="user_name")val userName:String,
//    @ColumnInfo(name="password")val password:String,
//
//)
package com.week6.openpdf.models
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index


import androidx.room.PrimaryKey

@Entity(tableName = "user_entity", indices = [Index(value = ["user_name"], unique = true)])
data class userItem(
    @PrimaryKey(autoGenerate = true) val userItemId: Int = 0,
    @ColumnInfo(name = "user_name") val userName: String,
    @ColumnInfo(name = "password") val password: String,
)



