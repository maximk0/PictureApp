package com.example.pictureapp.di

import android.content.Context
import androidx.room.Room
import com.example.pictureapp.data.storage.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "db"
    ).build()

    @Singleton
    @Provides
    fun providePhotoDao(database: AppDatabase) =
        database.favoritePhotoDao()

}
