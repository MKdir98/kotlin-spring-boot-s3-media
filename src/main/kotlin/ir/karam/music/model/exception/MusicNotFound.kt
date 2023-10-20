package ir.karam.music.model.exception

import me.alidg.errors.annotation.ExceptionMapping
import me.alidg.errors.annotation.ExposeAsArg
import org.springframework.http.HttpStatus

@ExceptionMapping(errorCode = "music.not_found", statusCode = HttpStatus.NOT_FOUND)
class MusicNotFound(@field:ExposeAsArg(0) private val id: Long) : Exception()