package me.vaimon.doomscroller.data.sources.paging

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import kotlinx.coroutines.delay
import me.vaimon.doomscroller.data.db.AppDatabase
import me.vaimon.doomscroller.data.db.PageKeyDao
import me.vaimon.doomscroller.data.db.PostDao
import me.vaimon.doomscroller.data.models.PageKey
import me.vaimon.doomscroller.data.models.Post
import me.vaimon.doomscroller.data.sources.ApiDataSource

@OptIn(ExperimentalPagingApi::class)
class PostRemoteMediator(
    private val database: AppDatabase,
    private val postDao: PostDao,
    private val pageKeyDao: PageKeyDao,
    private val apiDataSource: ApiDataSource
): RemoteMediator<Int, Post>() {
    override suspend fun load(loadType: LoadType, state: PagingState<Int, Post>): MediatorResult {
        return try {
            val loadingPage = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND ->
                    return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val remoteKey = pageKeyDao.remoteKey()
                    remoteKey!!.currentPage.plus(1)
                }
            }

            // Uncomment to emulate slow network and reach list bottom
            // delay(3000)

            val response = apiDataSource.getPosts(
                 page = loadingPage, pageSize = state.config.pageSize
            )

            database.withTransaction {
                if(loadType == LoadType.REFRESH){
                    postDao.clearAll()
                    pageKeyDao.clearAll()
                }

                pageKeyDao.insertOrReplace(PageKey(currentPage = loadingPage))
                postDao.insertAll(response)
            }

            MediatorResult.Success(
                endOfPaginationReached = false
            )
        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }

}