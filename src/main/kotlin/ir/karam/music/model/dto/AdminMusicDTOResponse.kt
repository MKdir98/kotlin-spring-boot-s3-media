package ir.karam.music.model.dto

import ir.karam.music.model.entity.Music
import java.util.*

class AdminMusicDTOResponse(music: Music) {
    private var id: Long
    private var title: String
    private var storageUri: String
    private var date: Date

    init {
        this.id = music.id!!
        this.title = music.title
        this.storageUri = music.storageUri
        this.date = music.date
    }
}