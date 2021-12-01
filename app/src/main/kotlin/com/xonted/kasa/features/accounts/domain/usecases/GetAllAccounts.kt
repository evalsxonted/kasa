package com.xonted.kasa.features.accounts.domain.usecases

import com.xonted.kasa.core.UseCaseResult
import com.xonted.kasa.features.accounts.domain.entities.MyAccount
import com.xonted.kasa.features.accounts.domain.repo.AccountRepo
import kotlinx.coroutines.flow.Flow

class GetAllAccounts(
    private val repo: AccountRepo
) {
    suspend operator fun invoke(): UseCaseResult<Flow<List<MyAccount>>> {
        return repo.getAllAccounts();
    }
}
