package me.vaimon.doomscroller.data.repositories.impl

import kotlinx.coroutines.delay
import me.vaimon.doomscroller.data.models.Post
import me.vaimon.doomscroller.data.repositories.PostRepository
import me.vaimon.doomscroller.data.sources.ApiDataSource

class PostRepositoryImpl(private val apiDataSource: ApiDataSource) : PostRepository {
    override suspend fun getPosts(): List<Post> {
        return apiDataSource.getPosts()
    }
}