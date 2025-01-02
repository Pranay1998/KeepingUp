package com.example.keepingup.data

import androidx.annotation.StringRes
import com.example.keepingup.R

sealed class Screen(@StringRes val name: Int) {
    data object Home : Screen(R.string.home)
    data object Scramble : Screen(R.string.scramble)
    data object Notification : Screen(R.string.notification)
}