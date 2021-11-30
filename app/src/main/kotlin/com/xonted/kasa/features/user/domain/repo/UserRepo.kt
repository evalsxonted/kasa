package com.xonted.kasa.features.user.domain.repo

import com.xonted.kasa.core.UseCaseResult
import com.xonted.kasa.features.user.domain.entities.MyUser

interface UserRepo {
    suspend fun getUser() : UseCaseResult<MyUser?>
    suspend fun insertUser(user: MyUser): UseCaseResult<Unit>
    suspend fun deleteUser(user: MyUser): UseCaseResult<Unit>
}