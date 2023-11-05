package com.example.pictureapp.domain.usecase

import com.example.pictureapp.domain.repository.NetworkPhotosRepository
import javax.inject.Inject

class GetRandomPhotosUseCase @Inject constructor(
    private val repository: NetworkPhotosRepository
) {
    operator fun invoke() = repository.getRandomPhotos()

}
