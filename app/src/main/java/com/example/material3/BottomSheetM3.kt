package com.example.material3

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomsheetM3() {
    var openBottomSheet by remember {
        mutableStateOf(false)
    }
    //skipPartiallyExpanded only opens partially
    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()
    Button(onClick = { openBottomSheet = true }) {
        Text(text = "Show BottomSheet")

    }
    if (openBottomSheet) {
        ModalBottomSheet(sheetState = bottomSheetState,
            onDismissRequest = { openBottomSheet = false },

            dragHandle = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    BottomSheetDefaults.DragHandle()
                    Text(text = "Comments", style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.height(10.dp))
                    Divider()
                }
            }


        ) {
            BottomSheetContent(onHideButtonClick = {
                scope.launch {
                    bottomSheetState.hide()
                }.invokeOnCompletion {
                    if (!bottomSheetState.isVisible) {
                        openBottomSheet = false
                    }
                }
            })
        }
    }
}

@Composable
fun BottomSheetContent(onHideButtonClick: () -> Unit) {
    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        items(50) {
            ListItem(headlineContent = { Text(text = "item $it") }, leadingContent = {
                Icon(imageVector = Icons.Default.Favorite, contentDescription = "")
            })
        }
        item {
            Button(modifier = Modifier.fillMaxWidth(), onClick = { onHideButtonClick() }) {
                Text(text = "Cancel")
            }

        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun StandaradBottomSheet() {
    var scope = rememberCoroutineScope()
    var scaffoldState = rememberBottomSheetScaffoldState()
    BottomSheetScaffold(scaffoldState = scaffoldState, sheetContent = {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(128.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Swipe up to expand sheet")
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(64.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Sheet content")
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {scope.launch { scaffoldState.bottomSheetState.partialExpand() } }) {
                Text(text = "Click Button to collapse sheet")
            }
        }
    }) { innerPadding ->
        //main screen content
        StandardBottomSheetContent(innerPadding)
    }
}

@Composable
fun StandardBottomSheetContent(innerPadding: PaddingValues) {
    Box(modifier = Modifier.padding(innerPadding)) {
        Text(text = "Scaffold content")
    }
}
