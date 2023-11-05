package com.example.pictureapp.data.repository

import com.example.pictureapp.data.mapper.PhotoMapper
import com.example.pictureapp.data.storage.FavoritePhotoDao
import com.example.pictureapp.domain.model.Photo
import com.example.pictureapp.domain.repository.StoragePhotosRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class StoragePhotosRepositoryImpl @Inject constructor(
    private val favoritePhotoDao: FavoritePhotoDao,
    private val mapper: PhotoMapper
): StoragePhotosRepository {
    override fun getFavoritePhotos() =
        favoritePhotoDao.getAllFavoritePhotos().map{
            mapper.mapDbModelListToEntityList(it)
        }

    override suspend fun addFavoritePhoto(photo: Photo) {
        favoritePhotoDao.addPhoto(mapper.mapEntityToDbModel(photo))
    }

    override fun deletePhoto(photo: Photo) {
        favoritePhotoDao.deletePhoto(photoId = photo.id)
    }

}
