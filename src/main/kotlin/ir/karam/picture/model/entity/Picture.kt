package ir.karam.picture.model.entity

import ir.karam.etc.domain.BaseEntity
import java.util.Date
import javax.persistence.Entity
import javax.persistence.Temporal
import javax.persistence.TemporalType

@Entity
class Picture(
    id: Long? = null,
    val title: String,
    val storageUri: String,
    @Temporal(TemporalType.TIMESTAMP)
    val date: Date,
) : BaseEntity(id)