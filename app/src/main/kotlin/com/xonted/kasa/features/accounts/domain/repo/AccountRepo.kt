package com.xonted.kasa.features.accounts.domain.repo

import com.xonted.kasa.core.UseCaseResult
import com.xonted.kasa.features.accounts.domain.entities.MyAccount
import kotlinx.coroutines.flow.Flow


interface AccountRepo {
    suspend fun getAllAccounts() : UseCaseResult<Flow<List<MyAccount>>>
    suspend fun getAccount(id: Int): UseCaseResult<MyAccount>
    suspend fun deleteAccount(account: MyAccount): UseCaseResult<Unit>
    suspend fun insertAccount(account: MyAccount): UseCaseResult<Unit>
}