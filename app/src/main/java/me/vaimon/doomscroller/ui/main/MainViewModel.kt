package me.vaimon.doomscroller.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import me.vaimon.doomscroller.data.repositories.PostRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val postRepository: PostRepository
): ViewModel() {
    val postPagingFlow = Pager(
        PagingConfig(
            initialLoadSize = 20,
            pageSize = 20,
            prefetchDistance = 1,
            enablePlaceholders = false
        )
    ){
        postRepository.pagingSource
    }.flow.cachedIn(viewModelScope)
}