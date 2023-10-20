package ir.karam.newspaper.model.dto

import ir.karam.newspaper.model.entity.Newspaper
import java.util.*

class AdminNewspaperDTOResponse(newspaper: Newspaper) {
    private var id: Long
    private var title: String
    private var storageUri: String
    private var date: Date

    init {
        this.id = newspaper.id!!
        this.title = newspaper.title
        this.storageUri = newspaper.storageUri
        this.date = newspaper.date
    }
}