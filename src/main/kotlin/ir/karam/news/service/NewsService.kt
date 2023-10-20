package ir.karam.news.service

import ir.karam.news.model.entity.News
import ir.karam.news.model.exception.NewsNotFound
import ir.karam.news.repository.NewsRepository
import ir.karam.media.service.S3Service
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*


@Service
class NewsService(
    private val newsRepository: NewsRepository,
) {
    fun get(id: Long): News {
        return newsRepository.findById(id).orElseThrow {
            NewsNotFound(id)
        }
    }

    fun list(pageable: Pageable): Page<News> {
        return newsRepository.findAll(pageable)
    }

    fun store(title: String, description: String, uri: String): News {
        return newsRepository.save(
            News(
                title = title,
                storageUri = uri,
                date = Date(),
                description = description,
            )
        )
    }

    fun update(id: Long, description: String, title: String, uri: String): News {
        val news = newsRepository.findById(id).orElseThrow { NewsNotFound(id) }
        return newsRepository.save(
            News(
                id = news.id,
                title = title,
                storageUri = uri,
                date = Date(),
                description = description,
            )
        )
    }
}