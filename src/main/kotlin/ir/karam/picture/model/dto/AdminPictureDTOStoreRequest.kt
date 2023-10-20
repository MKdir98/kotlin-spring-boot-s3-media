package ir.karam.picture.model.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
class AdminPictureDTOStoreRequest(
    var title: String,
    var image: String,
    var subImages: List<String>,
)