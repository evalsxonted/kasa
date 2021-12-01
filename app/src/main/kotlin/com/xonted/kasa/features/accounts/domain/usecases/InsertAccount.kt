package com.xonted.kasa.features.accounts.domain.usecases

import com.xonted.kasa.core.UseCaseResult
import com.xonted.kasa.features.accounts.domain.entities.MyAccount
import com.xonted.kasa.features.accounts.domain.repo.AccountRepo


class InsertAccount(
    private val repo: AccountRepo
) {
    suspend operator fun invoke(account: MyAccount): UseCaseResult<Unit> {
        return repo.insertAccount(account = account);
    }
}
