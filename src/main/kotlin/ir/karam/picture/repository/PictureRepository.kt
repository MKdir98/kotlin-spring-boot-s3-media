package ir.karam.picture.repository

import ir.karam.picture.model.entity.Picture
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PictureRepository : JpaRepository<Picture, Long>