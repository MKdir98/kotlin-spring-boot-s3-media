package ir.karam.news.controller

import ir.karam.news.model.dto.UserNewsDTOResponse
import ir.karam.news.service.NewsService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/v1/news")
class NewsController(private val newsService: NewsService) {

    @GetMapping("{id}")
    fun get(@PathVariable id: Long): UserNewsDTOResponse {
        return UserNewsDTOResponse(newsService.get(id))
    }

    @GetMapping("")
    fun list(pageable: Pageable): Page<UserNewsDTOResponse> {
        return newsService.list(pageable).map {
            UserNewsDTOResponse(it)
        }
    }
}