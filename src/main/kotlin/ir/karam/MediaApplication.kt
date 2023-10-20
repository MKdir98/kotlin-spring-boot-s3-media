package ir.karam

import com.google.gson.GsonBuilder
import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import me.alidg.errors.ExceptionLogger
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.autoconfigure.gson.GsonBuilderCustomizer
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.web.servlet.LocaleResolver
import org.springframework.web.servlet.i18n.SessionLocaleResolver
import java.util.*
import java.util.function.Consumer


@SpringBootApplication(exclude = [JacksonAutoConfiguration::class])
@EntityScan("ir")
@EnableScheduling
open class MediaApplication {

    private val log: Logger = LoggerFactory.getLogger(this::class.java)

    @Bean
    open fun localeResolver(): LocaleResolver {
        val sessionLocaleResolver = SessionLocaleResolver()
        sessionLocaleResolver.setDefaultLocale(Locale("fa"))
        return sessionLocaleResolver
    }

    @Bean
    open fun customOpenAPI(
        @Value("\${springdoc.description}") appDescription: String?,
        @Value("\${springdoc.version}") appVersion: String?
    ): OpenAPI {
        return OpenAPI()
            .components(
                Components()
                    .addSecuritySchemes(
                        "authorization",
                        SecurityScheme()
                            .type(SecurityScheme.Type.HTTP)
                            .scheme("bearer")
                            .bearerFormat("JWT")
                    )
            )
            .security(listOf(SecurityRequirement().addList("authorization")))
            .info(
                Info()
                    .title("Inventory API")
                    .version(appVersion)
                    .description(appDescription)
            )
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(MediaApplication::class.java, *args)
        }
    }

    @Bean
    open fun getExceptionLogger(): ExceptionLogger? {
        return ExceptionLogger { exception: Throwable? ->
            log.error(
                exception?.message,
                exception
            )
        }
    }
}