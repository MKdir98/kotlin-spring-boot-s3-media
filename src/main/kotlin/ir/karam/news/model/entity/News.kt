package ir.karam.news.model.entity

import ir.karam.etc.domain.BaseEntity
import java.util.Date
import javax.persistence.Entity
import javax.persistence.Temporal
import javax.persistence.TemporalType

@Entity
class News(
    id: Long? = null,
    val title: String,
    val storageUri: String,
    @Temporal(TemporalType.TIMESTAMP)
    val date: Date,
    val description: String,
) : BaseEntity(id)