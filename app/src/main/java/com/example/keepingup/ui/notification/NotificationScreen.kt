package com.example.keepingup.ui.notification

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.keepingup.R

@Composable
fun NotificationScreen(notificationViewModel: NotificationViewModel = viewModel()) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { notificationViewModel.onSimpleNotificationClicked() },
            shape = RectangleShape
        ) {
            Text(text = stringResource(R.string.simple_notification))
        }

        Button(
            onClick = { },
            shape = RectangleShape
        ) {
            Text(text = stringResource(R.string.push_notification))
        }
    }
}