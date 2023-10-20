package ir.karam.newspaper.repository

import ir.karam.newspaper.model.entity.Newspaper
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NewspaperRepository : JpaRepository<Newspaper, Long>