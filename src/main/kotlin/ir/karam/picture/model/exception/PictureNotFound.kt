package ir.karam.picture.model.exception

import me.alidg.errors.annotation.ExceptionMapping
import me.alidg.errors.annotation.ExposeAsArg
import org.springframework.http.HttpStatus

@ExceptionMapping(errorCode = "picture.not_found", statusCode = HttpStatus.NOT_FOUND)
class PictureNotFound(@field:ExposeAsArg(0) private val id: Long) : Exception()