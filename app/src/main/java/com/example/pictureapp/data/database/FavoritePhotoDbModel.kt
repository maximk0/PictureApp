package com.example.pictureapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_photos")
data class FavoritePhotoDbModel(
    @PrimaryKey
    val id: String,
    val author: String,
    val url: String
)
