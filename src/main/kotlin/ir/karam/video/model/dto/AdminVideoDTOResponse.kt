package ir.karam.video.model.dto

import ir.karam.video.model.entity.Video
import java.util.*

class AdminVideoDTOResponse(video: Video) {
    private var id: Long
    private var title: String
    private var storageUri: String
    private var date: Date
    private var time: Long

    init {
        this.id = video.id!!
        this.title = video.title
        this.storageUri = video.storageUri
        this.date = video.date
        this.time = video.time
    }
}