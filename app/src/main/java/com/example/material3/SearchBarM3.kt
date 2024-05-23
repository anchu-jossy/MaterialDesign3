package com.example.material3

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchM3() {
    var searchValue by remember {
        mutableStateOf("")
    }
    var isActive by remember {
        mutableStateOf(false)
    }
    val searchHistory = listOf("Koltin", "Android", "Sdk")
    SearchBar(
        query = searchValue,
        onQueryChange = {
            searchValue = it
        },
        onSearch = {
        },
        active = isActive,
        onActiveChange = {
            isActive = it
        },
        placeholder = {
            Text(text = "Search here....")
        },
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
        content = {
            searchHistory.forEach { item ->
                ListItem(headlineContent = { Text(text = item) }, modifier = Modifier.clickable { searchValue=item }, leadingContent = {
                    Icon(painter = painterResource(id = R.drawable.icon_history), contentDescription = null)
                })
            }
        },
        trailingIcon = {
            Row() {
                IconButton(onClick = {
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_mic),
                        contentDescription = null
                    )
                }
                if (isActive) {

                    IconButton(onClick = {
                        if (searchValue.isNotEmpty()) searchValue = "" else isActive = false
                    }) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = null)
                    }
                }
            }
        },

        )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DocSearchM3() {
    var searchValue by remember {
        mutableStateOf("")
    }
    var isActive by remember {
        mutableStateOf(false)
    }
    val searchHistory = listOf("Koltin", "Android", "Sdk")
    DockedSearchBar(
        query = searchValue,
        onQueryChange = {
            searchValue = it
        },
        onSearch = {
        },
        active = isActive,
        onActiveChange = {
            isActive = it
        },
        placeholder = {
            Text(text = "Search here....")
        },
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
        content = {
            searchHistory.forEach { item ->
                ListItem(headlineContent = { Text(text = item) }, modifier = Modifier.clickable { searchValue=item }, leadingContent = {
                    Icon(painter = painterResource(id = R.drawable.icon_history), contentDescription = null)
                })
            }
        },
        trailingIcon = {
            Row() {
                IconButton(onClick = {
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_mic),
                        contentDescription = null
                    )
                }
                if (isActive) {

                    IconButton(onClick = {
                        if (searchValue.isNotEmpty()) searchValue = "" else isActive = false
                    }) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = null)
                    }
                }
            }
        },

        )
}