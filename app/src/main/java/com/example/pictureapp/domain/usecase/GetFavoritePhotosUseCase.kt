package com.example.pictureapp.domain.usecase

import com.example.pictureapp.domain.repository.StoragePhotosRepository
import javax.inject.Inject


class GetFavoritePhotosUseCase @Inject constructor(
    private val repository: StoragePhotosRepository
) {
    operator fun invoke() = repository.getFavoritePhotos()

}
