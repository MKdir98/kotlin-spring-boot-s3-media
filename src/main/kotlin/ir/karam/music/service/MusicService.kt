package ir.karam.music.service

import ir.karam.music.model.entity.Music
import ir.karam.music.model.exception.MusicNotFound
import ir.karam.music.repository.MusicRepository
import ir.karam.media.service.S3Service
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*


@Service
class MusicService(
    private val musicRepository: MusicRepository,
    private val s3Service: S3Service
) {
    fun get(id: Long): Music {
        return musicRepository.findById(id).orElseThrow {
            MusicNotFound(id)
        }
    }

    fun list(pageable: Pageable): Page<Music> {
        return musicRepository.findAll(pageable)
    }

    fun store(title: String, uri: String): Music {
        return musicRepository.save(
            Music(
                title = title,
                storageUri = uri,
                date = Date()
            )
        )
    }

    fun update(id: Long, title: String, uri: String): Music {
        val news = musicRepository.findById(id).orElseThrow { MusicNotFound(id) }
        return musicRepository.save(
            Music(
                id = news.id,
                title = title,
                storageUri = uri,
                date = Date()
            )
        )
    }
}