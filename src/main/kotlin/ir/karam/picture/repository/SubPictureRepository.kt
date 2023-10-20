package ir.karam.picture.repository

import ir.karam.picture.model.entity.SubPicture
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SubPictureRepository : JpaRepository<SubPicture, Long>