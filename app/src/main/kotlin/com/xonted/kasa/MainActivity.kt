package com.xonted.kasa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.xonted.kasa.features.user.data.datasource.UserDatabase
import com.xonted.kasa.ui.pages.home.Home
import com.xonted.kasa.ui.pages.login.Login
import com.xonted.kasa.ui.theme.KasaTheme
import com.xonted.kasa.ui.theme.color4


lateinit var db: UserDatabase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            KasaTheme {
                val navController = rememberNavController()
                db = Room.databaseBuilder(
                    applicationContext,
                    UserDatabase::class.java,
                    UserDatabase.databaseName
                ).build()
                Surface(color = color4, modifier = Modifier.fillMaxSize()) {
                    NavHost(
                        navController = navController,
                        "login"
                    ) {
                        composable("login") { Login(
                            navigateToHome = {
                                navController.popBackStack(navController.graph.startDestinationId, true)
                                navController.graph.setStartDestination("home")
                                navController.navigate("home")
                            }
                        ) }
                        composable("home") { Home() }
                    }
                }

            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}