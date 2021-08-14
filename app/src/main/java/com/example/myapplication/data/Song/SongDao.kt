package com.example.myapplication.data.Song

import androidx.room.Dao
import androidx.room.Query

@Dao
interface SongDao {

    @Query("SELECT * FROM songs WHERE singerId=:id")
    fun getSongsBySingerId(id: Int) : List<Song>
    
    @Query("SELECT * FROM songs WHERE id=:id")
    fun getLyricSong(id: Int) : Song

}