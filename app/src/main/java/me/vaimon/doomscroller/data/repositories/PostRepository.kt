package me.vaimon.doomscroller.data.repositories

import kotlinx.coroutines.flow.Flow
import me.vaimon.doomscroller.data.models.Post

interface PostRepository {
    suspend fun getPosts(): List<Post>
}