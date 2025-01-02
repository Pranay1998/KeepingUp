package com.example.keepingup

import com.example.keepingup.data.Screen
import com.example.keepingup.nav.NavigationManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Singleton
    @Provides
    fun navigationManager(): NavigationManager {
        return NavigationManager(Screen.Home)
    }
}