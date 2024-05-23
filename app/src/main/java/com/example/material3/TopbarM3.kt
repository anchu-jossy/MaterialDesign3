package com.example.material3

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.ListItem
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarM3() {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    Scaffold(modifier = Modifier
        .fillMaxSize()
        .nestedScroll(scrollBehavior.nestedScrollConnection), topBar = {
       // TopBar(scrollBehavior)
     //   MediumTopBarM3(scrollBehavior)
        LargeBar(scrollBehavior)
         //   CenterTopBar(scrollBehavior = scrollBehavior)
    }) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(50) {
                ListItem(headlineContent = { Text(text = "Item $it") }, leadingContent = {
                    Icon(imageVector = Icons.Default.Face, contentDescription = null)
                })
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(scrollBehavior: TopAppBarScrollBehavior) {
    TopAppBar(title = { Text(text = "Title of the screen") }, navigationIcon = {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
        }
    }, actions = {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Filled.Share, contentDescription = null)
        }
    }, scrollBehavior = scrollBehavior)
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MediumTopBarM3(scrollBehavior: TopAppBarScrollBehavior) {
    MediumTopAppBar(title = { Text(text = "Title of the screen") }, navigationIcon = {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
        }
    }, actions = {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Filled.Share, contentDescription = null)
        }
    }, scrollBehavior = scrollBehavior)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenterTopBar(scrollBehavior: TopAppBarScrollBehavior) {
    CenterAlignedTopAppBar(title = { Text(text = "Title of the screen") }, navigationIcon = {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
        }
    }, actions = {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Filled.Share, contentDescription = null)
        }
    }, scrollBehavior = scrollBehavior)
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LargeBar(scrollBehavior: TopAppBarScrollBehavior) {
    LargeTopAppBar(title = { Text(text = "Title of the screen") }, navigationIcon = {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
        }
    }, actions = {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Filled.Share, contentDescription = null)
        }
    }, scrollBehavior = scrollBehavior)
}