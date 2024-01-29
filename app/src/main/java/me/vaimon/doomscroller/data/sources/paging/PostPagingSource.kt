package me.vaimon.doomscroller.data.sources.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import me.vaimon.doomscroller.data.models.Post
import me.vaimon.doomscroller.data.sources.ApiDataSource

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