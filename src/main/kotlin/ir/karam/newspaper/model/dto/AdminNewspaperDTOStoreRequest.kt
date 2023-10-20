package ir.karam.newspaper.model.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
class AdminNewspaperDTOStoreRequest(
    var title: String,
    var image: String
)