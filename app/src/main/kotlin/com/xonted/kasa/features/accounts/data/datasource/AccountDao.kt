package com.xonted.kasa.features.accounts.data.datasource

import androidx.room.*
import com.xonted.kasa.features.accounts.data.models.AccountModel
import kotlinx.coroutines.flow.Flow

@Dao
interface AccountDao  {
    @Query("SELECT * FROM AccountModel")
    suspend fun getAllAccounts() : Flow<List<AccountModel>>;

    @Query("SELECT * FROM AccountModel WHERE id = :id")
    suspend fun getAccountById(id: Int): AccountModel?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAccount(accountModel: AccountModel);

    @Delete
    suspend fun deleteAccount(accountModel: AccountModel);
}


