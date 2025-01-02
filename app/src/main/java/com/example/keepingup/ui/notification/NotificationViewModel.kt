package com.example.keepingup.ui.notification

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.compose.ui.res.stringResource
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.ViewModel
import com.example.keepingup.R
import com.example.keepingup.getResourceUri
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class NotificationViewModel @Inject constructor(
    @ApplicationContext private val appContext: Context,
): ViewModel() {

    fun onSimpleNotificationClicked() {
        val notification = NotificationCompat
            .Builder(appContext, "0")
            .setContentTitle(appContext.getString(R.string.alarm))
            .setContentText(appContext.getString(R.string.alarm_notification))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setAutoCancel(true)
            .setSound(appContext.getResourceUri(R.raw.alarm))
            .build()


        with(NotificationManagerCompat.from(appContext)) {
            if (ActivityCompat.checkSelfPermission(appContext, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED) {
                notify(0, notification)
            }
        }
    }

    fun onPushNotificationClicked() {

    }
}