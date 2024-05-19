package com.example.material3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.material3.ui.theme.Material3Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3Theme() {
                // A surface container using the 'background' color from the theme

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {


                    LazyColumn {

                        items(count = 20) {
                            ImageCard(
                                title = "baco ipsum",
                                desc = "bacon ipsum decor iwl  is right kind of the dutratiuon of India",
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }

                    Box(contentAlignment = Alignment.Center) {
                        //   FloatingActionButton(onClick = {}) {
                        //BadgeM3()
                        //  SliderM3()
                        //  CheckboxM3()
                        //  AssistChip()
                        // ElevatedAssistChip()
                        //  FilteredChip()
                        //   ElevatedFilteredChip()
                        //  SuggestionChipM3()
                        InputChipM3()
                        //  }
                    }
                }
                TopBar()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    @Preview
    fun TopBar() {
        TopAppBar(
            title = {
                Text(text = "Material 3")
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.secondary,
                titleContentColor = MaterialTheme.colorScheme.onSecondary
            )
        )
    }
}




