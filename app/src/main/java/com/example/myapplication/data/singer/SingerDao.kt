package com.example.myapplication.data.singer

import androidx.room.Dao
import androidx.room.Query

@Dao
interface SingerDao {
    @Query("SELECT * FROM singers")
    fun getAllSinger() : List<Singer>



}