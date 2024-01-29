package me.vaimon.doomscroller.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import me.vaimon.doomscroller.data.models.Post

interface PostRepository {
    fun getPostPagerFlow(): Flow<PagingData<Post>>
}