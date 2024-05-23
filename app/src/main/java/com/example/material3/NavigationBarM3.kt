package com.example.material3

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun NavigationBar() {

    Scaffold(bottomBar ={
        NavigationBarM3()
    } ) {
        paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(50){
         ListItem(headlineContent = { Text(text = "Item Count $it")})
            }
        }
    }

}
@Composable
fun NavigationBarM3() {
    var selectedItem by remember {
        mutableStateOf(0)
    }
    NavigationBar {
        baritems.forEachIndexed { index, barItem ->
            val selected = selectedItem == index
            NavigationBarItem(selected = selected, onClick = {
                selectedItem = index
            }, icon = {
                Icon(
                    imageVector = if (selected) {
                        barItem.selectedItem
                    } else barItem.unselectedItem, contentDescription = null
                )
            }, label = {
                Text(text=barItem.title)
            })
        }
    }
}

data class BarItem(
    val title: String,
    val selectedItem: ImageVector,
    val unselectedItem: ImageVector,
    val route: String
)

var baritems = listOf(
    BarItem("Home", Icons.Filled.Home, Icons.Outlined.Home, "home"),
    BarItem("Contacts", Icons.Filled.Face, Icons.Outlined.Face, "contacts"),
    BarItem("Settings", Icons.Filled.Settings, Icons.Outlined.Settings, "settings"),
    BarItem("Shopping", Icons.Filled.ShoppingCart, Icons.Outlined.ShoppingCart, "shopping")
)