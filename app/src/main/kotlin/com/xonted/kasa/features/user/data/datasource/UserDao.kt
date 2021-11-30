package com.xonted.kasa.features.user.data.datasource

import com.xonted.kasa.features.user.data.models.UserModel
import androidx.room.*

@Dao
interface UserDao  {
    @Query("SELECT * FROM UserModel")
    suspend fun getUser() : UserModel?;
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userModel: UserModel);
    @Delete
    suspend fun deleteUser(userModel: UserModel);
}