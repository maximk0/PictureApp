package com.example.pictureapp.domain

class GetRandomPhotosUseCase(
    private val repository: PhotosRepository
) {
    operator fun invoke() = repository.getRandomPhotos()

}