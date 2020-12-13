package com.logol.java.developer.Repository;

import java.util.Date;
import java.util.List;

import com.logol.java.developer.Entity.News;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface INewsRepository extends JpaRepository<News, String> {
    News findOneById(String id);
 
    @Query(value = "SELECT N"
        + " FROM News N"
        + " WHERE (:title IS NULL OR LOWER(N.title) LIKE LOWER(CONCAT('%',:title,'%')))"
        + " AND (:description IS NULL OR LOWER(N.description) LIKE LOWER(CONCAT('%',:description,'%')))"
        + " AND (:createdFrom IS NULL OR N.createdAt >= :createdFrom)"
        + " AND (:createdTo IS NULL OR N.createdAt <= :createdTo)")
    List<News> getByFilterAndSortByColumn(@Param("title") String title, @Param("description") String description, 
        @Param("createdFrom") Date createdFrom, @Param("createdTo") Date createdTo, Pageable pageable);
}