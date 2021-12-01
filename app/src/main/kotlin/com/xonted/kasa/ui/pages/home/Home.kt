package com.xonted.kasa.ui.pages.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.xonted.kasa.features.accounts.data.datasource.AccountDatabase

@Composable
fun Home(
    dbAccount : AccountDatabase,
    vm: HomeViewModel = HomeViewModel()
) {
    Scaffold {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(text = "hi from home")
        }
    }
}