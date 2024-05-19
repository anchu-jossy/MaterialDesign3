package com.example.material3

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier


@Composable
fun SwitchM3() {
    var isChecked by remember {
        mutableStateOf(true)
    }
    Switch(checked = isChecked, onCheckedChange = {
        isChecked = it

    }, thumbContent = {
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "",
            modifier = Modifier.size(SwitchDefaults.IconSize)
        )
    })
}