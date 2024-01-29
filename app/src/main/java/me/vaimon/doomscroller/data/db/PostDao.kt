package me.vaimon.doomscroller.data.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import me.vaimon.doomscroller.data.models.Post

@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(posts: List<Post>)

    @Query("SELECT * FROM posts")
    fun pagingSource(): PagingSource<Int, Post>

    @Query("DELETE FROM posts")
    suspend fun clearAll()
}