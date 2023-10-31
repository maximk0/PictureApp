package com.example.pictureapp.domain

class LikePhotoUseCase(
    private val repository: PhotosRepository
) {

    operator fun invoke(photo: Photo) = repository.likePhoto(photo)

}
