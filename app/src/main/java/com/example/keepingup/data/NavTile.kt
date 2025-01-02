package com.example.keepingup.data

import androidx.annotation.StringRes
import com.example.keepingup.R

data class NavTile(@StringRes val name: Int, val screen: Screen)

val navTiles = listOf(
    NavTile(R.string.scramble, Screen.Scramble),
    NavTile(R.string.notification, Screen.Notification),
    NavTile(R.string.video_player, Screen.Scramble),
    NavTile(R.string.music_player, Screen.Scramble)
)
