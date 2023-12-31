package com.example.pictureapp.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FavoritePhotoDbModel::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun favoritePhotoDao(): FavoritePhotoDao

}
