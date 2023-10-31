package com.example.pictureapp.domain

class UnlikePhotoUseCase(
    private val repository: PhotosRepository
) {

    operator fun invoke(photo: Photo) = repository.unlikePhoto(photo)

}
