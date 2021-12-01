package com.xonted.kasa.features.accounts.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.xonted.kasa.features.accounts.domain.entities.MyAccount

@Entity
data class AccountModel (
    override val accountName: String,
    override val user: String,
    override val password: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
): MyAccount
