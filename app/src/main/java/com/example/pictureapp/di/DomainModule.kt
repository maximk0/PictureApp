package com.example.pictureapp.di

import com.example.pictureapp.data.repository.NetworkPhotosRepositoryImpl
import com.example.pictureapp.data.repository.StoragePhotosRepositoryImpl
import com.example.pictureapp.domain.usecase.GetFavoritePhotosUseCase
import com.example.pictureapp.domain.usecase.GetRandomPhotosUseCase
import com.example.pictureapp.domain.usecase.LikePhotoUseCase
import com.example.pictureapp.domain.repository.NetworkPhotosRepository
import com.example.pictureapp.domain.repository.StoragePhotosRepository
import com.example.pictureapp.domain.usecase.UnlikePhotoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DomainModule {

    @Singleton
    @Provides
    fun provideNetworkPhotosRepository(
        networkPhotosRepositoryImpl: NetworkPhotosRepositoryImpl
    ): NetworkPhotosRepository = networkPhotosRepositoryImpl

    @Singleton
    @Provides
    fun provideStoragePhotosRepository(
        storagePhotosRepositoryImpl: StoragePhotosRepositoryImpl
    ): StoragePhotosRepository = storagePhotosRepositoryImpl

    @Singleton
    @Provides
    fun provideGetRandomPhotosUseCase(
        networkPhotosRepository: NetworkPhotosRepository
    ): GetRandomPhotosUseCase = GetRandomPhotosUseCase(networkPhotosRepository)

    @Singleton
    @Provides
    fun provideLikePhotoUseCase(
        networkPhotosRepository: StoragePhotosRepository
    ): LikePhotoUseCase = LikePhotoUseCase(networkPhotosRepository)

    @Singleton
    @Provides
    fun provideUnlikePhotoUseCase(
        networkPhotosRepository: StoragePhotosRepository
    ): UnlikePhotoUseCase = UnlikePhotoUseCase(networkPhotosRepository)

    @Singleton
    @Provides
    fun provideGetFavoritePhotosUseCase(
        networkPhotosRepository: StoragePhotosRepository
    ): GetFavoritePhotosUseCase = GetFavoritePhotosUseCase(networkPhotosRepository)

}
