package me.vaimon.doomscroller.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import me.vaimon.doomscroller.data.models.Post

@Database(entities = [Post::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao

    companion object{
        const val DATABASE_NAME = "postDB"
    }
}