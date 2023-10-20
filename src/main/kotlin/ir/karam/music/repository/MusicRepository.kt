package ir.karam.music.repository

import ir.karam.music.model.entity.Music
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MusicRepository : JpaRepository<Music, Long>