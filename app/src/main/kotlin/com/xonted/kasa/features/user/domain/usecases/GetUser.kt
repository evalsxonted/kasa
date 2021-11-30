package com.xonted.kasa.features.user.domain.usecases

import com.xonted.kasa.core.UseCaseResult
import com.xonted.kasa.features.user.domain.entities.MyUser
import com.xonted.kasa.features.user.domain.repo.UserRepo

class GetUser(
    private  val repo: UserRepo
) {
    suspend operator fun invoke() : UseCaseResult<MyUser?> {
        return repo.getUser();
    }
}