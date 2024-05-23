package com.example.material3

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun CircularProgressLoaderM3() {
    var isLoading by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        if (isLoading) {
            CircularProgressIndicator()
        }
        Button(onClick = { isLoading = !isLoading }) {
            Text(text = "Load me")
        }

    }
}

@Composable
fun CircularPercentageProgressLoaderM3() {
    var progress by remember {
        mutableStateOf(0.1f)
    }
    val animateProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec, label = ""
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        CircularProgressIndicator(progress = animateProgress)

        Button(onClick = { if (progress < 1f) progress += 0.1f }) {
            Text(text = "Load me")
        }

    }
}



@Composable
fun LinearProgressLoaderM3() {
    var isLoading by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        if (isLoading) {
       LinearProgressIndicator()
        }
        Button(onClick = { isLoading = !isLoading }) {
            Text(text = "Load me")
        }

    }
}


@Composable
fun LinearPercentageProgressLoaderM3() {
    var progress by remember {
        mutableStateOf(0.1f)
    }
    val animateProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec, label = ""
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        LinearProgressIndicator(progress = animateProgress)

        Button(onClick = { if (progress < 1f) progress += 0.1f }) {
            Text(text = "Load me")
        }

    }
}
