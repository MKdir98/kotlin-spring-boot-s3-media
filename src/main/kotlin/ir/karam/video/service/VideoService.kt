package ir.karam.video.service

import ir.karam.video.model.entity.Video
import ir.karam.video.model.exception.VideoNotFound
import ir.karam.video.repository.VideoRepository
import ir.karam.media.service.S3Service
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.util.*


@Service
class VideoService(
    private val videoRepository: VideoRepository,
    private val s3Service: S3Service
) {
    fun get(id: Long): Video {
        return videoRepository.findById(id).orElseThrow {
            VideoNotFound(id)
        }
    }

    fun list(pageable: Pageable): Page<Video> {
        return videoRepository.findAll(pageable)
    }

    fun store(title: String, uri: String): Video {
        return videoRepository.save(
            Video(
                title = title,
                storageUri = uri,
                date = Date(),
                time = 60 // todo: calculate time of video
            )
        )
    }

    fun update(id: Long, title: String, uri: String): Video {
        val news = videoRepository.findById(id).orElseThrow { VideoNotFound(id) }
        return videoRepository.save(
            Video(
                id = news.id,
                title = title,
                storageUri = uri,
                date = Date(),
                time = 60 // todo: calculate time of video
            )
        )
    }
}