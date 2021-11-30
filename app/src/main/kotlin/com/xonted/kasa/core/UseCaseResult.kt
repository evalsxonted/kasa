package com.xonted.kasa.core


sealed class UseCaseResult<out R> {
    data class Success<out T>(val data: T) : UseCaseResult<T>()
    data class Failure(
        val messageToShow: String,
        val messageToDev: String?
    ) : UseCaseResult<Nothing>()
}


