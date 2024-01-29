package me.vaimon.doomscroller.data.repositories.impl

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import me.vaimon.doomscroller.data.db.AppDatabase
import me.vaimon.doomscroller.data.models.Post
import me.vaimon.doomscroller.data.repositories.PostRepository
import me.vaimon.doomscroller.data.sources.paging.PostPagingSource
import me.vaimon.doomscroller.data.sources.paging.PostRemoteMediator

class PostRepositoryImpl(
    private val database: AppDatabase,
    private val postRemoteMediator: PostRemoteMediator
) : PostRepository {
    @OptIn(ExperimentalPagingApi::class)
    override fun getPostPagerFlow(): Flow<PagingData<Post>> = Pager(
        config = PagingConfig(
            initialLoadSize = 20,
            pageSize = 20,
            prefetchDistance = 4
        ),
        remoteMediator = postRemoteMediator
    ) {
        database.postDao().pagingSource()
    }.flow

}