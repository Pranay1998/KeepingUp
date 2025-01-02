package com.example.keepingup.ui.app

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.keepingup.R
import com.example.keepingup.data.Screen
import com.example.keepingup.ui.home.HomeScreen
import com.example.keepingup.ui.notification.NotificationScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KeepingUpAppBar(
    currentScreen: Screen,
    canPopScreen: Boolean,
    onPopScreen: () -> Unit,
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.name)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        navigationIcon = {
            if (canPopScreen) {
                IconButton(onClick = { onPopScreen() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button),
                    )
                }
            }
        }
    )
}

@Composable
fun KeepingUpApp(
    currentScreen: Screen,
    canPopScreen: Boolean,
    onPopScreen: () -> Unit
) {
    Scaffold(
        topBar = {
            KeepingUpAppBar(
                currentScreen,
                canPopScreen,
                onPopScreen = onPopScreen
            )
        }
    ) { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {
            when(currentScreen) {
                Screen.Home -> HomeScreen()
                Screen.Scramble -> { }
                Screen.Notification -> NotificationScreen()
            }
        }
    }
}