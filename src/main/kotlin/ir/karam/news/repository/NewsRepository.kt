package ir.karam.news.repository

import ir.karam.news.model.entity.News
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NewsRepository : JpaRepository<News, Long>