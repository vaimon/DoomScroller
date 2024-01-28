package me.vaimon.doomscroller.data.repositories

import kotlinx.coroutines.flow.Flow
import me.vaimon.doomscroller.data.models.Post
import me.vaimon.doomscroller.data.sources.PostPagingSource

interface PostRepository {
    val pagingSource: PostPagingSource
}