package com.org.argentinacompartepage.models.daos;

import com.org.argentinacompartepage.entities.TestimonyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TestimonyDao extends JpaRepository<TestimonyEntity, Long> {
    List<TestimonyEntity> findByNombreContainingIgnoreCase(String nombre);

    List<TestimonyEntity> findByActivoTrueOrderByOrdenAscFechaCreacionDesc();

    List<TestimonyEntity> findByDestacadoTrueAndActivoTrueOrderByOrdenAscFechaCreacionDesc();

    @Query("""
            SELECT t FROM TestimonyEntity t
            WHERE (:nombre IS NULL OR :nombre = '' OR
            LOWER(t.nombre) LIKE LOWER(CONCAT('%', :nombre, '%')))
            AND (:activo IS NULL OR t.activo = :activo)
            AND (:destacado IS NULL OR t.destacado = :destacado)
            AND (:id IS NULL OR t.id = :id)
            """)
    List<TestimonyEntity> filterTestimonies(
            @Param("nombre") String nombre,
            @Param("activo") Boolean activo,
            @Param("destacado") Boolean destacado,
            @Param("id") Long id
    );
}
