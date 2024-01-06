//package com.week6.openpdf
//
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//
//@Dao
//interface TaskDoe {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//     fun insertItem(taskItem: userItem)
//
//     @Query("Select * From user_data where id =:iditem")
//     fun getUserId(iditem :Int): List<userItem>
//
//    @Query("Select * From user_data where user_name =:useritem")
//    fun getuserName(useritem :String): userItem
//}
package com.week6.openpdf
import androidx.room.Query
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.week6.openpdf.models.userItem

@Dao
interface UserDoe {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItem(userItem: userItem)


    @Query("SELECT * FROM user_entity WHERE user_name = :uName")
    fun getUserByUsername(uName: String): List<userItem>
//





//    @Query("SELECT password FROM user_entity WHERE password = :pass_word")
//    fun getPasswordByUsername(pass_word: String): userItem?

}
