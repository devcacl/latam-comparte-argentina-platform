package com.org.argentinacompartepage.models.daos;

import com.org.argentinacompartepage.entities.NewsEntity;
import com.org.argentinacompartepage.entities.enums.NewsStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NewsDao extends JpaRepository<NewsEntity, Long> {
    List<NewsEntity> findByTituloContainingIgnoreCase(String titulo);

    List<NewsEntity> findByEstado(NewsStatus estado);

    List<NewsEntity> findByDestacadaTrueAndEstado(NewsStatus estado);

    List<NewsEntity> findAllByOrderByFechaPublicacionDesc();

    @Query("""
            SELECT n FROM NewsEntity n
            WHERE (:titulo IS NULL OR :titulo = '' OR
            LOWER(n.titulo) LIKE LOWER(CONCAT('%', :titulo, '%')))
            AND (:categoria IS NULL OR :categoria = '' OR
            LOWER(n.categoria) LIKE LOWER(CONCAT('%', :categoria, '%')))
            AND (:estado IS NULL OR n.estado = :estado)
            AND (:autorId IS NULL OR n.autor.id = :autorId)
            AND (:id IS NULL OR n.id = :id)
            """)
    List<NewsEntity> filterNews(
            @Param("titulo") String titulo,
            @Param("categoria") String categoria,
            @Param("estado") NewsStatus estado,
            @Param("autorId") Long autorId,
            @Param("id") Long id
    );
}
