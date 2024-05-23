package com.example.material3

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@Composable
fun SnackbarM3() {
    val snackbarHostState = SnackbarHostState()
    val scope = rememberCoroutineScope()

    Scaffold(snackbarHost = { SnackbarHost(hostState = snackbarHostState) }

    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar(
                        message = "Couldn't send pics",
                        actionLabel = "Retry",
                        withDismissAction = true,
                        duration = SnackbarDuration.Short
                    )
                }
            }) {
                Text(text = "ShowSnackBar")

            }
        }
    }
}

