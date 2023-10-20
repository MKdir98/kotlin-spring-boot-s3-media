package ir.karam.picture.model.dto

import ir.karam.picture.model.entity.Picture
import ir.karam.picture.model.entity.SubPicture
import java.util.*

class UserPictureDTOResponse(picture: Picture, subPictures: List<SubPicture>) {
    private var id: Long
    private var title: String
    private var storageUri: String
    private var date: Date
    private var subPictures: List<String>

    init {
        this.id = picture.id!!
        this.title = picture.title
        this.storageUri = picture.storageUri
        this.date = picture.date
        this.subPictures = subPictures.map { it.storageUri }
    }
}