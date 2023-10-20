package ir.karam.etc.domain

import com.google.gson.annotations.Expose
import javax.persistence.*

@MappedSuperclass
open class BaseEntity(
    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    open var id: Long? = null
)
