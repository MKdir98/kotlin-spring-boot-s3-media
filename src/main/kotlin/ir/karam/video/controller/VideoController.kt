package ir.karam.video.controller

import ir.karam.video.model.dto.UserVideoDTOResponse
import ir.karam.video.service.VideoService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/v1/video")
class VideoController(private val videoService: VideoService) {

    @GetMapping("{id}")
    fun get(@PathVariable id: Long): UserVideoDTOResponse {
        return UserVideoDTOResponse(videoService.get(id))
    }

    @GetMapping("")
    fun list(pageable: Pageable): Page<UserVideoDTOResponse> {
        return videoService.list(pageable).map {
            UserVideoDTOResponse(it)
        }
    }
}