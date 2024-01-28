package me.vaimon.doomscroller.data.sources

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.delay
import me.vaimon.doomscroller.data.models.Post

class PostPagingSource(
    private val apiDataSource: ApiDataSource
) : PagingSource<Int, Post>() {
    override fun getRefreshKey(state: PagingState<Int, Post>): Int? {
        return state.anchorPosition?.let {
            val page = state.closestPageToPosition(it)
            page?.prevKey?.plus(1) ?: page?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Post> {
        val nextPage = params.key ?: 1
        delay(2000)
        return try{
            val loadedPosts = apiDataSource.getPosts(page = nextPage, pageSize = 20)
            LoadResult.Page(
                data = loadedPosts,
                prevKey = null,
                nextKey = if(loadedPosts.isNotEmpty()) nextPage + 1 else null
            )
        } catch (e: Exception){
            LoadResult.Error(e)
        }
    }

}