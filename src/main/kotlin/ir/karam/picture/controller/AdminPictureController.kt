package ir.karam.picture.controller

import ir.karam.picture.model.dto.AdminPictureDTOResponse
import ir.karam.picture.model.dto.AdminPictureDTOStoreRequest
import ir.karam.picture.service.PictureService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/admin/picture")
class AdminPictureController(private val pictureService: PictureService) {
    @GetMapping("{id}")
    fun get(@PathVariable id: Long): AdminPictureDTOResponse {
        return AdminPictureDTOResponse(pictureService.get(id), listOf())
    }

    @GetMapping("")
    fun list(pageable: Pageable): Page<AdminPictureDTOResponse> {
        return pictureService.list(pageable).map {
            AdminPictureDTOResponse(it, listOf())
        }
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    fun store(@RequestBody body: AdminPictureDTOStoreRequest): AdminPictureDTOResponse {
        return AdminPictureDTOResponse(pictureService.store(body.title, body.image, body.subImages), listOf())
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    fun update(@RequestBody body: AdminPictureDTOStoreRequest, @PathVariable id: Long): AdminPictureDTOResponse {
        return AdminPictureDTOResponse(pictureService.update(id, body.title, body.image), listOf())
    }
}