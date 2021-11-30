package com.xonted.kasa.core.errors
import com.xonted.kasa.core.UseCaseResult

class HandleFailure(
    private val failure: UseCaseResult.Failure
) {
    init {
        println("failure occurred");
        println(failure.messageToShow);
        println(failure.messageToDev);
    }

    fun uploadToDev() {
        //todo
    }

    fun saveToLocalLog() {
        //todo
    }

    fun showErrorPage() {
        //todo
    }
}