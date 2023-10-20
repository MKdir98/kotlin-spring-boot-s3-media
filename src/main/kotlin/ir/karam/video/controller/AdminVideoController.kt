package ir.karam.video.controller

import ir.karam.video.model.dto.AdminVideoDTOResponse
import ir.karam.video.model.dto.AdminVideoDTOStoreRequest
import ir.karam.video.service.VideoService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/admin/video")
class AdminVideoController(private val videoService: VideoService) {
    @GetMapping("{id}")
    fun get(@PathVariable id: Long): AdminVideoDTOResponse {
        return AdminVideoDTOResponse(videoService.get(id))
    }

    @GetMapping("")
    fun list(pageable: Pageable): Page<AdminVideoDTOResponse> {
        return videoService.list(pageable).map {
            AdminVideoDTOResponse(it)
        }
    }

    @PostMapping(
        "", consumes = [MediaType.MULTIPART_FORM_DATA_VALUE,
            MediaType.APPLICATION_OCTET_STREAM_VALUE]
    )
    @ResponseStatus(HttpStatus.CREATED)
    fun store(
        @RequestBody body: AdminVideoDTOStoreRequest,
    ): AdminVideoDTOResponse {
        return AdminVideoDTOResponse(videoService.store(body.title, body.uri))
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    fun update(
        @RequestBody body: AdminVideoDTOStoreRequest,
        @PathVariable id: Long
    ): AdminVideoDTOResponse {
        return AdminVideoDTOResponse(videoService.update(id, body.title, body.uri))
    }
}