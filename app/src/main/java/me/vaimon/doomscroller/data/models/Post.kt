package me.vaimon.doomscroller.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
data class Post(
    @PrimaryKey(autoGenerate = true) val _id: Int = 0,
    val title: String,
    val body: String
) {
}