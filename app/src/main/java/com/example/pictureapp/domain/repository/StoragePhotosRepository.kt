package com.example.pictureapp.domain.repository

import com.example.pictureapp.domain.model.Photo
import kotlinx.coroutines.flow.Flow

interface StoragePhotosRepository {

    fun getFavoritePhotos(): Flow<List<Photo>>

    suspend fun addFavoritePhoto(photo: Photo)

    fun deletePhoto(photo: Photo)

}
