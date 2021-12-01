package com.xonted.kasa.features.accounts.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.xonted.kasa.features.accounts.data.models.AccountModel


@Database(
    entities = [
        AccountModel::class
    ],
    version = 1
)
abstract class AccountDatabase : RoomDatabase() {
    abstract  val accountDao : AccountDao;
    companion object {
        const val databaseName = "account_db";
    }
}