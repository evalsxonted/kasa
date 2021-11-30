package com.xonted.kasa.ui.pages.login

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xonted.kasa.core.UseCaseResult
import com.xonted.kasa.core.errors.HandleFailure
import com.xonted.kasa.db
import com.xonted.kasa.features.user.data.impls.UserImpl
import com.xonted.kasa.features.user.domain.entities.MyUser
import com.xonted.kasa.features.user.domain.entities.MyUserImp
import com.xonted.kasa.features.user.domain.usecases.GetUser
import com.xonted.kasa.features.user.domain.usecases.InsertUser
import com.xonted.kasa.ui.components.input.InputViewModel
import kotlinx.coroutines.launch
import java.lang.Exception

class LoginViewModel(
    private val navigateToHome: ()->Unit,
    private val scaffoldState: ScaffoldState,
) : ViewModel() {
    var wait: Boolean by mutableStateOf(false)
    val phoneViewModel: InputViewModel = InputViewModel(
        label = "phone",
        icon = Icons.Rounded.Phone,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
    )
    val passwordViewModel: InputViewModel = InputViewModel(
        label = "password",
        icon = Icons.Rounded.Lock
    )

    fun logIn() {
        if (!wait) {
            wait = true
            viewModelScope.launch {
                val myUserResult: UseCaseResult<MyUser?> = GetUser(
                    repo = UserImpl(
                        dao = db.userDao
                    )
                ).invoke()
                if (myUserResult is UseCaseResult.Success) {
                    if (myUserResult.data == null) {
                        addNewUser()
                    } else {
                        checkCurrentUser(myUserResult.data)
                    }
                } else if (myUserResult is UseCaseResult.Failure) {
                    HandleFailure(myUserResult)
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = "failed to get user",
                    )
                }
            }
        }
    }

    private suspend fun checkCurrentUser(myUser: MyUser) {
        val checked = try {
            myUser.password == passwordViewModel.text.trim() &&
                    myUser.phoneNumber == phoneViewModel.text.trim().toInt()
        } catch (e: Exception) {
            false
        }
        if (checked) {
            navigateToHome()
        } else {
            wait = false
            scaffoldState.snackbarHostState.showSnackbar(
                message = "wrong user info",
            )
        }
        wait = false
    }

    private suspend fun addNewUser() {
        val phoneNumber:Int = try {
            phoneViewModel.text.trim().toInt()
        } catch (e: Exception) {
            wait = false
            scaffoldState.snackbarHostState.showSnackbar(
                message = "invalid phone number",
            )
            0
        }
        val result: UseCaseResult<Unit> = InsertUser(
            repo = UserImpl(
                dao = db.userDao
            )
        ).invoke(
            MyUserImp(
                phoneNumber,
                passwordViewModel.text.trim()
            )
        )
        if (result is UseCaseResult.Success) {
            navigateToHome()
        } else if (result is UseCaseResult.Failure) {
            HandleFailure(result)
            wait = false
            scaffoldState.snackbarHostState.showSnackbar(
                message = result.messageToShow,
            )
        }
        wait = false
    }


}