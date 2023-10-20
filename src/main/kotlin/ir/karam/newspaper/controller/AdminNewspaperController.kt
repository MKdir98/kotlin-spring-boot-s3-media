package ir.karam.newspaper.controller

import ir.karam.newspaper.model.dto.AdminNewspaperDTOResponse
import ir.karam.newspaper.model.dto.AdminNewspaperDTOStoreRequest
import ir.karam.newspaper.service.NewspaperService
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
@RequestMapping("/admin/newspaper")
class AdminNewspaperController(private val newspaperService: NewspaperService)  {
    @GetMapping("{id}")
    fun get(@PathVariable id: Long): AdminNewspaperDTOResponse {
        return AdminNewspaperDTOResponse(newspaperService.get(id))
    }

    @GetMapping("")
    fun list(pageable: Pageable): Page<AdminNewspaperDTOResponse> {
        return newspaperService.list(pageable).map {
            AdminNewspaperDTOResponse(it)
        }
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    fun store(@RequestBody body: AdminNewspaperDTOStoreRequest) :AdminNewspaperDTOResponse{
        return AdminNewspaperDTOResponse(newspaperService.store(body.title, body.image))
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    fun update(@RequestBody body: AdminNewspaperDTOStoreRequest, @PathVariable id: Long) :AdminNewspaperDTOResponse{
        return AdminNewspaperDTOResponse(newspaperService.update(id, body.title, body.image))
    }
}