package ir.karam.music.controller

import ir.karam.music.model.dto.AdminMusicDTOResponse
import ir.karam.music.model.dto.AdminMusicDTOStoreRequest
import ir.karam.music.service.MusicService
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
@RequestMapping("/admin/music")
class AdminMusicController(private val musicService: MusicService)  {
    @GetMapping("{id}")
    fun get(@PathVariable id: Long): AdminMusicDTOResponse {
        return AdminMusicDTOResponse(musicService.get(id))
    }

    @GetMapping("")
    fun list(pageable: Pageable): Page<AdminMusicDTOResponse> {
        return musicService.list(pageable).map {
            AdminMusicDTOResponse(it)
        }
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    fun store(@RequestBody body: AdminMusicDTOStoreRequest) :AdminMusicDTOResponse{
        return AdminMusicDTOResponse(musicService.store(body.title, body.uri))
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    fun update(@RequestBody body: AdminMusicDTOStoreRequest, @PathVariable id: Long) :AdminMusicDTOResponse{
        return AdminMusicDTOResponse(musicService.update(id, body.title, body.uri))
    }
}