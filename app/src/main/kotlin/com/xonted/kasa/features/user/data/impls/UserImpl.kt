package com.xonted.kasa.features.user.data.impls

import com.xonted.kasa.features.user.data.models.UserModel
import com.xonted.kasa.core.UseCaseResult
import com.xonted.kasa.features.user.data.datasource.UserDao
import com.xonted.kasa.features.user.domain.entities.MyUser
import com.xonted.kasa.features.user.domain.repo.UserRepo

class UserImpl(
    private val dao: UserDao
) : UserRepo {
    override suspend fun getUser(): UseCaseResult<MyUser?> {
        return try {
            UseCaseResult.Success<MyUser?>(dao.getUser())
        } catch (e: Exception) {
            UseCaseResult.Failure(
                messageToDev = e.message + "   " + e.stackTraceToString(),
                messageToShow = "error getting user"
            )
        }
    }

    override suspend fun insertUser(user: MyUser): UseCaseResult<Unit> {
        return try {
            val result: Unit = dao.insertUser(userModel = UserModel(
                user.phoneNumber,
                user.password
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

    override suspend fun deleteUser(user: MyUser): UseCaseResult<Unit> {
        return try {
            val result: Unit =dao.deleteUser(userModel = UserModel(
                user.phoneNumber,
                user.password
            ))
            UseCaseResult.Success(result)
        } catch (e: Exception) {
            UseCaseResult.Failure(
                messageToDev = e.message + "   " + e.stackTraceToString(),
                messageToShow = "error inserting user"
            )
        }
    }
}