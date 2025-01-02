package com.example.keepingup.ui.home

import androidx.lifecycle.ViewModel
import com.example.keepingup.data.NavTile
import com.example.keepingup.data.navTiles
import com.example.keepingup.nav.NavigationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val navigationManager: NavigationManager
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState(navTiles))

    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun onTileClicked(navTile: NavTile) {
        navigationManager.navigateTo(navTile.screen)
    }
}