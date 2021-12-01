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
import com.xonted.kasa.features.accounts.data.datasource.AccountDatabase
import com.xonted.kasa.features.user.data.datasource.UserDatabase
import com.xonted.kasa.ui.pages.home.Home
import com.xonted.kasa.ui.pages.login.Login
import com.xonted.kasa.ui.theme.KasaTheme
import com.xonted.kasa.ui.theme.color4


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            KasaTheme {
                val navController = rememberNavController()
                val dbUser: UserDatabase = Room.databaseBuilder(
                    applicationContext,
                    UserDatabase::class.java,
                    UserDatabase.databaseName
                ).build()
                val dbAccount: AccountDatabase = Room.databaseBuilder(
                    applicationContext,
                    AccountDatabase::class.java,
                    AccountDatabase.databaseName
                ).build()
                Surface(color = color4, modifier = Modifier.fillMaxSize()) {
                    NavHost(
                        navController = navController,
                        "login"
                    ) {
                        composable("login") {
                            Login(
                                navigateToHome = {
                                    navController.popBackStack(
                                        navController.graph.startDestinationId,
                                        true
                                    )
                                    navController.graph.setStartDestination("home")
                                    navController.navigate("home")
                                },
                                dbUser = dbUser
                            )
                        }
                        composable("home") { Home(
                            dbAccount = dbAccount
                        ) }
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