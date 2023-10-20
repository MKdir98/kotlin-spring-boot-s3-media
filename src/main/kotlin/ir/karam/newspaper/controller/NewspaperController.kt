package ir.karam.newspaper.controller

import ir.karam.newspaper.model.dto.UserNewspaperDTOResponse
import ir.karam.newspaper.service.NewspaperService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/v1/newspaper")
class NewspaperController(private val newspaperService: NewspaperService) {

    @GetMapping("{id}")
    fun get(@PathVariable id: Long): UserNewspaperDTOResponse {
        return UserNewspaperDTOResponse(newspaperService.get(id))
    }

    @GetMapping("")
    fun list(pageable: Pageable): Page<UserNewspaperDTOResponse> {
        return newspaperService.list(pageable).map {
            UserNewspaperDTOResponse(it)
        }
    }
}