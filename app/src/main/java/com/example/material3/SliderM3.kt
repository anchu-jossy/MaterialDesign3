package com.example.material3

import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue


@Composable
fun SliderM3() {
    var state by remember {
        mutableStateOf(0f)
    }
    Slider(value = state, onValueChange ={state=it

    } )
}