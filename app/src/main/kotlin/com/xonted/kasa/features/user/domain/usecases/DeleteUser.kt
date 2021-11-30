package com.xonted.kasa.features.user.domain.usecases

import com.xonted.kasa.core.UseCaseResult
import com.xonted.kasa.features.user.domain.entities.MyUser
import com.xonted.kasa.features.user.domain.repo.UserRepo

class DeleteUser(
    private  val repo: UserRepo
) {
    suspend operator fun invoke(user: MyUser): UseCaseResult<Unit>  {
        return repo.deleteUser(user = user);
    }
}
