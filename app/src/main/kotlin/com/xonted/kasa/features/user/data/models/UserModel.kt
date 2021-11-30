package com.xonted.kasa.features.user.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.xonted.kasa.features.user.domain.entities.MyUser

@Entity
data class UserModel(
    override val phoneNumber: Int,
    override val password: String,
    @PrimaryKey val id: Int = 0
) : MyUser;