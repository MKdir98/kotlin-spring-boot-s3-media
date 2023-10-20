package ir.karam.video.model.exception

import me.alidg.errors.annotation.ExceptionMapping
import me.alidg.errors.annotation.ExposeAsArg
import org.springframework.http.HttpStatus

@ExceptionMapping(errorCode = "video.not_found", statusCode = HttpStatus.NOT_FOUND)
class VideoNotFound(@field:ExposeAsArg(0) private val id: Long) : Exception()