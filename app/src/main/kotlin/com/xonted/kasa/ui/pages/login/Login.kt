package com.xonted.kasa.ui.pages.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xonted.kasa.ui.components.input.Input
import com.xonted.kasa.ui.theme.color1
import com.xonted.kasa.ui.theme.color5


@Composable
fun Login(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navigateToHome: ()->Unit,
    vm: LoginViewModel = LoginViewModel(
        navigateToHome,
        scaffoldState,
    )
) {

    Scaffold(scaffoldState = scaffoldState) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp, end = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Input(
                vm.phoneViewModel
            )
            Spacer(modifier = Modifier.height(20.dp))
            Input(
                vm.passwordViewModel
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { vm.logIn() },
                colors = ButtonDefaults.buttonColors(
                    contentColor = color5,
                    backgroundColor = color1
                ),
            ) {
                if (vm.wait) CircularProgressIndicator(
                    color = color5,
                    modifier = Modifier.size(width = 30.dp, height = 30.dp)
                )
                else Text(text = "LOGIN")
            }
        }
    }
}


@Preview
@Composable
fun prev() {

}


