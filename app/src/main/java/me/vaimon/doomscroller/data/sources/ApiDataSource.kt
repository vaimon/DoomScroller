package me.vaimon.doomscroller.data.sources

import me.vaimon.doomscroller.data.models.Post
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiDataSource {
    @GET("posts")
    suspend fun getPosts(@Query("page") page: Int, @Query("per_page") pageSize: Int): List<Post>

    companion object{
        const val BASE_URL = "https://gorest.co.in/public/v2/"
    }
}