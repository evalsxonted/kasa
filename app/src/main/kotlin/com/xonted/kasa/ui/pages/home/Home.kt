package com.xonted.kasa.ui.pages.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Home(
    vm: HomeViewModel = HomeViewModel()
) {
    Scaffold {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(text = "hi from home")
        }
    }
}