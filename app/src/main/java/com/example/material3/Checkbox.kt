package com.example.material3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CheckboxM3() {
    var options = listOf("lettuce", "tomato", "cheese")
    var checkedStates = remember {
        mutableStateMapOf<String, Boolean>().withDefault { false }
    }
    Column(modifier = Modifier.fillMaxWidth()) {
        options.forEach { item ->
            Row(
                modifier = Modifier.fillMaxWidth().height(56.dp)
                    .toggleable(value = checkedStates.getValue(item), onValueChange = {   checkedStates[item] = it }).padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(checked = checkedStates.getValue(item), onCheckedChange = {
                    checkedStates[item] = it
                })
                Text(text = item)
            }
        }
    }
}