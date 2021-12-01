package com.xonted.kasa.features.accounts.domain.usecases

import com.xonted.kasa.core.UseCaseResult
import com.xonted.kasa.features.accounts.domain.entities.MyAccount
import com.xonted.kasa.features.accounts.domain.repo.AccountRepo

class GetAccountById(
    private val repo: AccountRepo
) {
    suspend operator fun invoke(id: Int): UseCaseResult<MyAccount> {
        return repo.getAccount(id = id);
    }
}
