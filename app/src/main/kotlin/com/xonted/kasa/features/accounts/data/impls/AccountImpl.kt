package com.xonted.kasa.features.accounts.data.impls

import com.xonted.kasa.core.UseCaseResult
import com.xonted.kasa.features.accounts.data.datasource.AccountDao
import com.xonted.kasa.features.accounts.data.models.AccountModel
import com.xonted.kasa.features.accounts.domain.entities.MyAccount
import com.xonted.kasa.features.accounts.domain.repo.AccountRepo
import kotlinx.coroutines.flow.Flow

class AccountImpl(
    private val dao: AccountDao
) : AccountRepo {
    override suspend fun getAllAccounts(): UseCaseResult<Flow<List<MyAccount>>> {
        return try {
            UseCaseResult.Success<Flow<List<MyAccount>>>(dao.getAllAccounts())
        } catch (e: Exception) {
            UseCaseResult.Failure(
                messageToDev = e.message + "   " + e.stackTraceToString(),
                messageToShow = "error getting accounts"
            )
        }
    }

    override suspend fun getAccount(id: Int): UseCaseResult<MyAccount> {
        return try {
            UseCaseResult.Success<MyAccount>(dao.getAccountById(id= id)!!)
        } catch (e: Exception) {
            UseCaseResult.Failure(
                messageToDev = e.message + "   " + e.stackTraceToString(),
                messageToShow = "error getting account"
            )
        }
    }

    override suspend fun deleteAccount(account: MyAccount): UseCaseResult<Unit> {
        return try {
            val result: Unit =dao.deleteAccount(accountModel = AccountModel(
                accountName = account.accountName,
                user = account.user,
                password = account.password
            )
            )
            UseCaseResult.Success(result)
        } catch (e: Exception) {
            UseCaseResult.Failure(
                messageToDev = e.message + "   " + e.stackTraceToString(),
                messageToShow = "error deleting user"
            )
        }
    }

    override suspend fun insertAccount(account: MyAccount): UseCaseResult<Unit> {
        return try {
            val result: Unit = dao.insertAccount(accountModel = AccountModel(
                accountName = account.accountName,
                user = account.user,
                password = account.password
            )
            )
            UseCaseResult.Success(result)
        } catch (e: Exception) {
            UseCaseResult.Failure(
                messageToDev = e.message + "   " + e.stackTraceToString(),
                messageToShow = "error inserting user"
            )
        }
    }

}