package ir.karam.media.controller

import ir.karam.media.domain.dto.AdminMediaDTOResponse
import ir.karam.media.service.S3Service
import ir.karam.music.model.dto.AdminMusicDTOResponse
import ir.karam.music.model.dto.AdminMusicDTOStoreRequest
import ir.karam.music.service.MusicService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile


@RestController
@RequestMapping("/admin/media")
class AdminMediaController(private val s3Service: S3Service) {
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    fun store(
        @RequestPart("content") file: MultipartFile
    ): AdminMediaDTOResponse {
        return AdminMediaDTOResponse(s3Service.saveFile(file))
    }
}