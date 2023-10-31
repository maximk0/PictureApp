package com.example.pictureapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoritePhotoDao {

    @Query("SELECT * FROM favorite_photos")
    fun getAllFavoritePhotos(): Flow<List<FavoritePhotoDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPhoto(photo: FavoritePhotoDbModel)

    @Query("DELETE FROM favorite_photos WHERE id = :photoId")
    fun deletePhoto(photoId: String)

}
