package ir.karam.news.model.exception

import me.alidg.errors.annotation.ExceptionMapping
import me.alidg.errors.annotation.ExposeAsArg
import org.springframework.http.HttpStatus

@ExceptionMapping(errorCode = "news.not_found", statusCode = HttpStatus.NOT_FOUND)
class NewsNotFound(@field:ExposeAsArg(0) private val id: Long) : Exception()