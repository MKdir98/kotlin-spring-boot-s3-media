package ir.karam.picture.model.entity

import ir.karam.etc.domain.BaseEntity
import java.util.Date
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Temporal
import javax.persistence.TemporalType

@Entity
class SubPicture(
    id: Long? = null,
    val storageUri: String,
    @ManyToOne
    val picture: Picture,
) : BaseEntity(id)