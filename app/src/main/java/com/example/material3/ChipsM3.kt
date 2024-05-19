package com.example.material3

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier

@Composable
fun AssistChip() {
    androidx.compose.material3.AssistChip(
        onClick = { },
        label = { Text(text = "Do something") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Settings,
                contentDescription = "",
                modifier = Modifier.size(AssistChipDefaults.IconSize)
            )
        })

}

@Composable
fun ElevatedAssistChip() {
    androidx.compose.material3.ElevatedAssistChip(
        onClick = { },
        label = { Text(text = "Do something") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Settings,
                contentDescription = "",
                modifier = Modifier.size(AssistChipDefaults.IconSize)
            )
        })

}

@Composable
fun icons(seletced: Boolean): Unit? = if (seletced) {
    Icon(
        imageVector = Icons.Default.Done,
        contentDescription = "",
        modifier = Modifier.size(AssistChipDefaults.IconSize)
    )
} else {
    null
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilteredChip() {
    var selectedState by remember {
        mutableStateOf(false)
    }
    FilterChip(
        selected = selectedState,
        onClick = { selectedState = !selectedState },
        label = { Text(text = "DO Soetihing") }, leadingIcon = {
            icons(seletced = selectedState)
        }
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ElevatedFilteredChip() {
    var selectedState by remember {
        mutableStateOf(false)
    }
    ElevatedFilterChip(
        selected = selectedState,
        onClick = { selectedState = !selectedState },
        label = { Text(text = "DO Soetihing") }, leadingIcon = {
            icons(seletced = selectedState)
        }
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuggestionChipM3() {
    var selectedState by remember {
        mutableStateOf(false)
    }
    SuggestionChip(

        onClick = { selectedState = !selectedState },
        label = { Text(text = "Suggestions") }, icon = {
            Icon(imageVector = Icons.Default.Settings, contentDescription = "")
        }
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputChipM3() {
    var selectedState by remember {
        mutableStateOf(false)
    }
    InputChip(
        selected = selectedState,
        onClick = { selectedState = !selectedState },
        label = { Text(text = "Input") }, leadingIcon = {
            Icon(
                imageVector = Icons.Default.Done,
                contentDescription = "",
                modifier = Modifier.size(InputChipDefaults.IconSize)
            )
        }
    )

}