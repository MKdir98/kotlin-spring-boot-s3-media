package ir.karam.news.model.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
class AdminNewsDTOStoreRequest(
    var title: String,
    var description: String,
    var image: String,
)