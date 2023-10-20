package ir.karam.picture.controller

import ir.karam.picture.model.dto.UserPictureDTOResponse
import ir.karam.picture.service.PictureService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/v1/picture")
class PictureController(private val pictureService: PictureService) {

    @GetMapping("{id}")
    fun get(@PathVariable id: Long): UserPictureDTOResponse {
        return UserPictureDTOResponse(pictureService.get(id), listOf())
    }

    @GetMapping("")
    fun list(pageable: Pageable): Page<UserPictureDTOResponse> {
        return pictureService.list(pageable).map {
            UserPictureDTOResponse(it, listOf())
        }
    }
}