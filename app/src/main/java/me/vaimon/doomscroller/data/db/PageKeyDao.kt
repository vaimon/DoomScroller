package me.vaimon.doomscroller.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import me.vaimon.doomscroller.data.models.PageKey

@Dao
interface PageKeyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplace(remoteKey: PageKey)

    @Query("SELECT * FROM remote_keys LIMIT 1")
    suspend fun remoteKey(): PageKey?

    @Query("DELETE FROM remote_keys")
    suspend fun clearAll()
}