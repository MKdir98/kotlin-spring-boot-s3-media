package ir.karam.newspaper.model.exception

import me.alidg.errors.annotation.ExceptionMapping
import me.alidg.errors.annotation.ExposeAsArg
import org.springframework.http.HttpStatus

@ExceptionMapping(errorCode = "newspaper.not_found", statusCode = HttpStatus.NOT_FOUND)
class NewspaperNotFound(@field:ExposeAsArg(0) private val id: Long) : Exception()