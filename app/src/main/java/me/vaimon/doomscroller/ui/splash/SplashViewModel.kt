package me.vaimon.doomscroller.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel: ViewModel() {
    private val _uiState = MutableLiveData(SplashUiState())
    val uiState: LiveData<SplashUiState> = _uiState

    fun emulateLoadingProcess(){
        _uiState.value = _uiState.value?.copy(isLoading = true)
        viewModelScope.launch {
            delay(2500L)
            onLoadingProcessFinished()
        }
    }

    private fun onLoadingProcessFinished(){
        _uiState.value = _uiState.value?.copy(isLoading = false)
    }

    data class SplashUiState(
        val isLoading: Boolean = true
    )
}