package com.example.myapplication.data.singer

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "singers")
data class Singer(
    @PrimaryKey
    var id: Int,
    var name: String
)

