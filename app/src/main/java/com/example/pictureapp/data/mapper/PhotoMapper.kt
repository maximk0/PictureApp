package com.example.pictureapp.data.mapper

import com.example.pictureapp.data.network.PhotoDto
import com.example.pictureapp.data.storage.FavoritePhotoDbModel
import com.example.pictureapp.domain.model.Photo
import javax.inject.Inject

class PhotoMapper @Inject constructor() {

    fun mapEntityToDbModel(entity: Photo) = FavoritePhotoDbModel(
        id = entity.id,
        author = entity.author,
        url = entity.url,
        likeByUser = entity.likeByUser
    )

    private fun mapDbModelToEntity(dbModel: FavoritePhotoDbModel) = Photo(
        id = dbModel.id,
        author = dbModel.author,
        url = dbModel.url,
        likeByUser = dbModel.likeByUser
    )

    fun mapDbModelListToEntityList(dbModelList: List<FavoritePhotoDbModel>) =
        dbModelList.map { mapDbModelToEntity(it) }

    fun mapDtoModelToEntity(dtoModel: PhotoDto) = Photo(
        id = dtoModel.id,
        author = dtoModel.author,
        url = dtoModel.downloadUrl,
        likeByUser = false
    )

}
