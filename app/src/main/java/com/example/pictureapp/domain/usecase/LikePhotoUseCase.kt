package com.example.pictureapp.domain.usecase

import com.example.pictureapp.domain.model.Photo
import com.example.pictureapp.domain.repository.StoragePhotosRepository
import javax.inject.Inject

class LikePhotoUseCase @Inject constructor(
    private val repository: StoragePhotosRepository
) {

    suspend operator fun invoke(photo: Photo) = repository.addFavoritePhoto(photo)

}
