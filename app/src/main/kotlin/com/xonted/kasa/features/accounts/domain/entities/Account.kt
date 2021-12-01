package com.xonted.kasa.features.accounts.domain.entities

interface MyAccount {
    val accountName: String
    val user: String
    val password: String
}


data class MyAccountImp(
    override val accountName: String,
    override val user: String,
    override val password: String
): MyAccount