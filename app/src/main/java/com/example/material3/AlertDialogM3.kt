package com.example.material3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog


@Composable
fun AlertDialog() {
    var openDialog by remember {
        mutableStateOf(false)
    }
    IconButton(onClick = { openDialog = true }) {
        Icon(imageVector = Icons.Default.Delete, contentDescription = "")
    }
    if (openDialog) {
//        androidx.compose.material3.AlertDialog(
//            onDismissRequest = { openDialog = false },
//            confirmButton = {
//                TextButton(onClick = {
//                    openDialog = false
//                }) {
//                    Text(text = "No")
//                }
//            },
//            title = { Text(text = "Delete the image?") },
//            text = {
//                Text(text = "Are you sure delete this ?")
//            },
//            dismissButton = {
//                TextButton(onClick = {
//                    openDialog = false
//                }) {
//                    Text(text = "Yes")
//                }
//            },
//        )

        Dialog(onDismissRequest = { openDialog = false }) {
            Surface {
                Column(
                    modifier = Modifier.padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "Congratulation", style = MaterialTheme.typography.headlineMedium)
                    Text(text = "Tou have cleared all chats", style = MaterialTheme.typography.titleMedium)
                    Button(onClick = { openDialog = false }) {
                       Text(text = "ok")
                    }
                }
            }

        }

    }

}





