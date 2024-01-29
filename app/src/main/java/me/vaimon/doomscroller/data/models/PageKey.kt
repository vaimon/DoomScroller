package me.vaimon.doomscroller.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_keys")
data class PageKey(@PrimaryKey val id: Int = 1, val currentPage: Int)