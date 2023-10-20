package ir.karam.news.model.dto

import ir.karam.news.model.entity.News
import java.util.*

class UserNewsDTOResponse(news: News) {
    private var id: Long
    private var title: String
    private var storageUri: String
    private var date: Date
    private var description: String

    init {
        this.id = news.id!!
        this.title = news.title
        this.storageUri = news.storageUri
        this.date = news.date
        this.description = news.description
    }
}