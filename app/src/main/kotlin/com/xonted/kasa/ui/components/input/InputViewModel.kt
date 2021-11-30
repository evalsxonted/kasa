package com.xonted.kasa.ui.components.input

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel


class InputViewModel(
    private val initialText: String = "",
    val label: String = "",
    val icon: ImageVector = Icons.Rounded.Edit,
    val keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    val singleLine: Boolean = true,
) : ViewModel() {
    var text by mutableStateOf(initialText)

}