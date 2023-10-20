package ir.karam.newspaper.service

import ir.karam.newspaper.model.entity.Newspaper
import ir.karam.newspaper.model.exception.NewspaperNotFound
import ir.karam.newspaper.repository.NewspaperRepository
import ir.karam.media.service.S3Service
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*


@Service
class NewspaperService(
    private val newspaperRepository: NewspaperRepository,
    private val s3Service: S3Service
) {
    fun get(id: Long): Newspaper {
        return newspaperRepository.findById(id).orElseThrow {
            NewspaperNotFound(id)
        }
    }

    fun list(pageable: Pageable): Page<Newspaper> {
        return newspaperRepository.findAll(pageable)
    }

    fun store(title: String, uri: String): Newspaper {
        return newspaperRepository.save(Newspaper(
            title = title,
            storageUri = uri,
            date = Date()
        ))
    }

    fun update(id: Long, title: String, uri: String): Newspaper {
        val news = newspaperRepository.findById(id).orElseThrow { NewspaperNotFound(id) }
        return newspaperRepository.save(Newspaper(
            id = news.id,
            title = title,
            storageUri = uri,
            date = Date()
        ))
    }
}