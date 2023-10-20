package ir.karam.music.controller

import ir.karam.music.model.dto.UserMusicDTOResponse
import ir.karam.music.service.MusicService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/v1/music")
class MusicController(private val musicService: MusicService) {

    @GetMapping("{id}")
    fun get(@PathVariable id: Long): UserMusicDTOResponse {
        return UserMusicDTOResponse(musicService.get(id))
    }

    @GetMapping("")
    fun list(pageable: Pageable): Page<UserMusicDTOResponse> {
        return musicService.list(pageable).map {
            UserMusicDTOResponse(it)
        }
    }
}