package me.vaimon.doomscroller.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Post(
    @PrimaryKey val id: Int,
    val title: String,
    val body: String
) {
}