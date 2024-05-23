package com.example.material3


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun NavigationDrawer() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var selectedItem by remember {
        mutableStateOf(drawerItemList[0])
    }
    ModalNavigationDrawer(gesturesEnabled = drawerState.isOpen,
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(64.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Header", style = MaterialTheme.typography.headlineLarge)
                }
                drawerItemList.forEach {
                    NavigationDrawerItem(
                        icon = {
                            Icon(imageVector = it.icon, contentDescription = null)
                        },
                        label = { Text(text = it.label) },
                        selected = it == selectedItem,
                        onClick = {
                            scope.launch {
                                drawerState.close()
                            }
                            selectedItem = it
                        }, badge = {
                            Text(text = it.secondaryLabel)
                        })
                }
            }
        }, content = {

            content2(onMenuClick={
                scope.launch {
                    drawerState.open()
                }
            } )
//            Content(onClick = {
//                scope.launch {
//                    drawerState.open()
//                }
//            })
        }
    )
}

data class DrawerItem(val label: String, val icon: ImageVector, val secondaryLabel: String)

var drawerItemList = listOf(
    DrawerItem("Home", Icons.Filled.Home, "65"),
    DrawerItem("Favourite", Icons.Filled.Favorite, "85"),
    DrawerItem("Settings", Icons.Filled.Settings, "25"),
    DrawerItem("Share", Icons.Filled.Share, "55"),
    DrawerItem("Logout", Icons.Filled.Lock, "35")

)

@Composable
fun Content(onClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = ">> Swipe >>")
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { onClick() }) {
            Text(text = "Click to open")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun content2(onMenuClick:()->Unit) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Top Stories") },
            navigationIcon = {
                IconButton(onClick = { onMenuClick() }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                }
            },
        )
    }) { paddingValues ->
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)) {
            items(50) {
                androidx.compose.material3.ListItem(
                    headlineContent = { Text(text = "Item Count $it") },
                    leadingContent ={
                        Icon(imageVector = Icons.Default.Face, contentDescription = null)
                    }
                )
            }
        }

    }
}