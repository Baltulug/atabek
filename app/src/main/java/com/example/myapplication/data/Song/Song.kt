package com.example.myapplication.data.Song

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomMasterTable

@Entity(tableName = "songs")
data class  Song(
        @PrimaryKey
        val id: Int,
        val name: String,
        val text: String,
        val singerId: Int,
        var isFovorite: Int
)

