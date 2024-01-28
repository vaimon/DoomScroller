package me.vaimon.doomscroller.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import me.vaimon.doomscroller.data.models.Post

@Dao
interface PostDao {
    @Query("SELECT * FROM post")
    fun getAllPosts(): List<Post>

    @Insert
    fun insertPosts(posts: List<Post>)
}