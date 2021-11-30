package com.xonted.kasa.ui.components.input

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xonted.kasa.ui.theme.color1
import com.xonted.kasa.ui.theme.color2
import com.xonted.kasa.ui.theme.color3
import com.xonted.kasa.ui.theme.color5


@Composable
fun Input(inputViewModel: InputViewModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(10.dp),
        backgroundColor = Color.Transparent
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.background(color3),
        ) {

            TextField(
                value = inputViewModel.text,
                onValueChange = { inputViewModel.text = it },
                label = if (inputViewModel.label == "") {
                    null
                } else {
                    { Text(text = inputViewModel.label, style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W700,
                    ), ) }
                },

                modifier = Modifier.weight(1f),
                textStyle = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W800,
                    ),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = color1,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    focusedLabelColor = color5,
                    unfocusedLabelColor = color5

                ),
                singleLine = inputViewModel.singleLine
            )
            Icon(
                inputViewModel.icon,
                contentDescription = "",
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
                    .padding(start = 5.dp, end = 5.dp),
                tint = color2

            )
        }
    }
}


@Preview
@Composable
fun prev() {
    Input(
        inputViewModel = InputViewModel(
            initialText = "",
            label = "label",
            icon = Icons.Rounded.AddCircle

        )
    )
}
