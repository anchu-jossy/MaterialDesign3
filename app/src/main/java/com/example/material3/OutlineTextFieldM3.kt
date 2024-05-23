package com.example.material3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun OutlineTextFieldM3() {
    var email by rememberSaveable {
        mutableStateOf("")
    }
    val localController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = {
                Text(text = "Email")
            },
            placeholder = {
                Text(text = "Enter your email")
            },
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = null) },
            trailingIcon = {
                if (email.isNotEmpty()) {
                    IconButton(onClick = {
                        email = ""
                    }) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = null)
                    }
                } else
                    null
            },
            supportingText = {
                Text(text = "Please don't use company details")
            },
            isError = email.contains("."),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = {
                localController?.hide()
            }), singleLine = true


        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TextFieldM3() {
    var password by rememberSaveable {
        mutableStateOf("")
    }
    var isPasswordHideen by rememberSaveable {
        mutableStateOf(false)
    }
    val localController = LocalSoftwareKeyboardController.current
    TextField(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp), value = password, onValueChange = {
        password = it
    }, keyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Password,
        imeAction = ImeAction.Done
    ), keyboardActions = KeyboardActions(onDone = {
        localController?.hide()
    }), singleLine = true, label = {
        Text(text = "Password")
    }, placeholder = {
        Text(text = "Enter your password")
    }, supportingText = {
        Text(text = "Please don't use personal password")
    }, visualTransformation =
    if (isPasswordHideen) {
        PasswordVisualTransformation()
    } else VisualTransformation.None, trailingIcon = {
        val visibilityIcon = if (isPasswordHideen)
            painterResource(id = R.drawable.icon_visibility) else painterResource(id = R.drawable.icon_visibility_off)


        IconButton(onClick = {
            isPasswordHideen = !isPasswordHideen
        }) {
            Icon(
                    painter = visibilityIcon,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
            }
    }
    )
}