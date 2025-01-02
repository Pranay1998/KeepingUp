package com.example.keepingup

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.app.ActivityCompat
import com.example.keepingup.nav.NavigationManager
import com.example.keepingup.ui.app.KeepingUpApp
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject lateinit var navigationManager: NavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        requestRequiredPermissions()
        processIntent()
        setContent {
            MaterialTheme {
                val navigationState by navigationManager.navigationState.collectAsState()
                KeepingUpApp(
                    navigationState.currentScreen,
                    canPopScreen = navigationState.canPopScreen,
                    onPopScreen = { navigationManager.popScreen() }
                )
            }
        }
    }

    private fun requestRequiredPermissions() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.POST_NOTIFICATIONS), 0)
            }
        }
    }

    private fun processIntent() {
        val intent = intent
        if (intent != null) {
            val action = intent.action
            if (action != null) {
                when (action) {
                    "com.example.keepingup.SHOW_NOTIFICATION" -> {

                    }
                }
            }
        }
    }
}