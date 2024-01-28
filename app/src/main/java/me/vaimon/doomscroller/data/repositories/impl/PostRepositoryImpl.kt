package me.vaimon.doomscroller.data.repositories.impl

import me.vaimon.doomscroller.data.repositories.PostRepository
import me.vaimon.doomscroller.data.sources.PostPagingSource

class PostRepositoryImpl(private val _pagingSource: PostPagingSource) : PostRepository {
    override val pagingSource: PostPagingSource
        get() = _pagingSource
}