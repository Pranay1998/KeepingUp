package com.example.keepingup.nav

import com.example.keepingup.data.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Stack

class NavigationManager(startingScreen: Screen) {
    private val navigationStack: Stack<Screen> = Stack<Screen>().apply { push(startingScreen) }
    private val _navigationState: MutableStateFlow<NavigationState> = MutableStateFlow(NavigationState(startingScreen, false))

    val navigationState: StateFlow<NavigationState> = _navigationState.asStateFlow()

    private fun updateNavigationState() {
        if (navigationStack.size > 1) {
            _navigationState.value = NavigationState(navigationStack.peek(), true)
        } else {
            _navigationState.value = NavigationState(navigationStack.peek(), false)
        }
    }

    fun navigateTo(screen: Screen) {
        navigationStack.push(screen)
        updateNavigationState()
    }

    fun popScreen() {
        navigationStack.pop()
        updateNavigationState()
    }
}