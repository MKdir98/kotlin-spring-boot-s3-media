package ir.karam.news.controller

import ir.karam.news.model.dto.AdminNewsDTOResponse
import ir.karam.news.model.dto.AdminNewsDTOStoreRequest
import ir.karam.news.service.NewsService
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
@RequestMapping("/admin/news")
class AdminNewsController(private val newsService: NewsService) {
    @GetMapping("{id}")
    fun get(@PathVariable id: Long): AdminNewsDTOResponse {
        return AdminNewsDTOResponse(newsService.get(id))
    }

    @GetMapping("")
    fun list(pageable: Pageable): Page<AdminNewsDTOResponse> {
        return newsService.list(pageable).map {
            AdminNewsDTOResponse(it)
        }
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    fun store(@RequestBody body: AdminNewsDTOStoreRequest): AdminNewsDTOResponse {
        return AdminNewsDTOResponse(newsService.store(body.title, body.description, body.image))
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    fun update(@RequestBody body: AdminNewsDTOStoreRequest, @PathVariable id: Long): AdminNewsDTOResponse {
        return AdminNewsDTOResponse(newsService.update(id, body.title, body.description, body.image))
    }
}