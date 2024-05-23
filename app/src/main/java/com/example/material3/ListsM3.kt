package com.example.material3

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ListItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun ListsM3() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        items(items = tasks, key = { it.id }) { task ->
            ListItem(
                headlineContent = { Text(text = task.name) },
                leadingContent = {
                    Icon(imageVector = task.icon, contentDescription = null)
                }, supportingContent = {
                    Text(text = task.desc)
                },
                trailingContent = {
                    Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
                })
        }
    }
}

data class Task(val id: Int, val name: String, val icon: ImageVector, val desc: String)


val tasks = listOf(
    Task(1, "clean home", Icons.Outlined.CheckCircle, "Movie is the cinematography"),
    Task(2, "buy groceries", Icons.Outlined.ShoppingCart, "shopping cart has many things"),
    Task(3, "watch movie ", Icons.Outlined.Star, "star is most beautiful object"),
    Task(4, "call mom", Icons.Outlined.Home, "egg,home is better place ")


)

