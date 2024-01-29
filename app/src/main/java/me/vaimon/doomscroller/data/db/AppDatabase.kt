package me.vaimon.doomscroller.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import me.vaimon.doomscroller.data.models.PageKey
import me.vaimon.doomscroller.data.models.Post

@Database(entities = [Post::class, PageKey::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao

    abstract fun pageKeyDao(): PageKeyDao

    companion object{
        const val DATABASE_NAME = "postDB"
    }
}