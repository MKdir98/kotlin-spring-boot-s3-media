package ir.karam.music.model.entity

import ir.karam.etc.domain.BaseEntity
import java.util.Date
import javax.persistence.Entity
import javax.persistence.Temporal
import javax.persistence.TemporalType

@Entity
class Music(
    id: Long? = null,
    val title: String,
    val storageUri: String,
    @Temporal(TemporalType.TIMESTAMP)
    val date: Date,
) : BaseEntity(id)