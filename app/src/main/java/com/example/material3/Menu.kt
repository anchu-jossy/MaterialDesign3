package com.example.material3

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue


@Composable
fun Menu() {
    var openState by remember {
        mutableStateOf(false)
    }
    Box {
        IconButton(onClick = { openState = true }) {
            Icon(imageVector = Icons.Default.MoreVert, contentDescription = "")
        }
        DropdownMenu(expanded = openState, onDismissRequest = { openState = false }) {
            DropdownMenuItem(text = { Text(text = "Edit") }, onClick = { /*TODO*/ }, leadingIcon ={ Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = null
            )})
            DropdownMenuItem(text = { Text(text = "Settings") }, onClick = { /*TODO*/ }, leadingIcon ={ Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = null
            )})
            Divider()
            DropdownMenuItem(text = { Text(text = "Send Feedback") }, onClick = { /*TODO*/ }, leadingIcon ={ Icon(
                imageVector = Icons.Default.Email,
                contentDescription = null
            )})
            }

        }
    }
