package com.example.material3

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun FABM3() {
    val listState = rememberLazyListState()
    val isExpanded by remember {
        derivedStateOf { listState.firstVisibleItemIndex == 0 }
    }
    Scaffold(floatingActionButton = { ExtendedLargeFAB(isExpanded) }) { paddingValues ->
        LazyColumn(state = listState, modifier = Modifier.padding(paddingValues)) {
            items(50) {
                androidx.compose.material3.ListItem(headlineContent = { Text(text = "List item index is $it") })
            }
        }

    }
}

@Composable
fun FAB() {
    FloatingActionButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = Icons.Default.Add, contentDescription = null)
    }
}

@Composable
fun SmallFAB() {
    SmallFloatingActionButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = Icons.Default.Add, contentDescription = null)
    }
}

@Composable
fun LargeFAB() {
    LargeFloatingActionButton(onClick = { /*TODO*/ }) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = null,
            modifier = Modifier.height(FloatingActionButtonDefaults.LargeIconSize)
        )
    }
}

@Composable
fun ExtendedLargeFAB(isExpanded: Boolean) {
    ExtendedFloatingActionButton(onClick = { /*TODO*/ },
        icon = {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                modifier = Modifier.height(FloatingActionButtonDefaults.LargeIconSize)
            )
        }, text = { Text(text = "Compose") }, expanded = isExpanded
    )
}