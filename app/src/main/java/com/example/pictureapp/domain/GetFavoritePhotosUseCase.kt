package com.example.pictureapp.domain


class GetFavoritePhotosUseCase(
    private val repository: PhotosRepository
) {
    operator fun invoke() = repository.getFavoritePhotos()

}
