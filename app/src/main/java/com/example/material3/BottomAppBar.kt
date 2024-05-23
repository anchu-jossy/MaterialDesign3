package com.example.material3

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BottomAppBarM3(){
    Scaffold(bottomBar ={BottomAppBar()} ) {
        paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(50){
                ListItem(headlineContent = { Text(text = "Item Count $it") })
            }
        }
    }
}
@Composable
fun BottomAppBar() {

    androidx.compose.material3.BottomAppBar(actions =
    {
        Icon(imageVector = Icons.Filled.Check, contentDescription = "")
        Icon(imageVector = Icons.Filled.Edit, contentDescription = "")
        Icon(imageVector = Icons.Filled.Search, contentDescription = "")
        Icon(imageVector = Icons.Filled.Share, contentDescription = "")
    }, floatingActionButton = {
        FloatingActionButton(contentColor = BottomAppBarDefaults.containerColor,
            onClick = { /*TODO*/ },
            elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
        ) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "")

        }
    })

}