package com.xonted.kasa.features.user.data.datasource

import com.xonted.kasa.features.user.data.models.UserModel
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        UserModel::class
    ],
    version = 1
)
abstract class UserDatabase : RoomDatabase() {
    abstract  val userDao : UserDao;
    companion object {
        const val databaseName = "user_db";
    }
}