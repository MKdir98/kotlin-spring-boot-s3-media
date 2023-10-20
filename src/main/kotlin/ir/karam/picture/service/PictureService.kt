package ir.karam.picture.service

import ir.karam.picture.model.entity.Picture
import ir.karam.picture.model.entity.SubPicture
import ir.karam.picture.model.exception.PictureNotFound
import ir.karam.picture.repository.PictureRepository
import ir.karam.picture.repository.SubPictureRepository
import ir.karam.media.service.S3Service
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional


@Service
open class PictureService(
    private val pictureRepository: PictureRepository,
    private val subPictureRepository: SubPictureRepository,
    private val s3Service: S3Service
) {
    fun get(id: Long): Picture {
        return pictureRepository.findById(id).orElseThrow {
            PictureNotFound(id)
        }
    }

    fun list(pageable: Pageable): Page<Picture> {
        return pictureRepository.findAll(pageable)
    }

    @Transactional
    open fun store(title: String, uri: String, subImages: List<String>): Picture {
        val picture = pictureRepository.save(
            Picture(
                title = title,
                storageUri = uri,
                date = Date()
            )
        )
        subImages.forEach {
            subPictureRepository.save(
                SubPicture(
                    storageUri = it,
                    picture = picture
                )
            )
        }
        return picture
    }

    // todo: we can't update sub pictures by this method
    fun update(id: Long, title: String, uri: String): Picture {
        val news = pictureRepository.findById(id).orElseThrow { PictureNotFound(id) }
        return pictureRepository.save(
            Picture(
                id = news.id,
                title = title,
                storageUri = uri,
                date = Date()
            )
        )
    }
}