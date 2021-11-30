package com.xonted.kasa.features.user.domain.entities

interface MyUser {
     val phoneNumber: Int
     val password: String
}

data class MyUserImp(
     override val phoneNumber: Int,
     override val password: String,
): MyUser