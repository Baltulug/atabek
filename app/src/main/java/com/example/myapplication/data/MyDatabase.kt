package com.example.myapplication.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.data.singer.Singer
import com.example.myapplication.data.singer.SingerDao
import com.example.myapplication.data.Song.Song
import com.example.myapplication.data.Song.SongDao

@Database(entities = [Singer::class, Song::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    companion object {
        lateinit var INSTANCE: MyDatabase
        fun getInstance(context: Context): MyDatabase  {
            if (!::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    MyDatabase::class.java, "database.db"
                )
                    .allowMainThreadQueries()
                    .createFromAsset("baza.db")
                    .build()

            }
            return INSTANCE
        }
    }

    abstract fun singersDao(): SingerDao

    abstract fun songsDao(): SongDao
}