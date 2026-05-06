package com.org.argentinacompartepage.models.daos;

import com.org.argentinacompartepage.entities.ContactRequestEntity;
import com.org.argentinacompartepage.entities.enums.ContactPurpose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactRequestDao extends JpaRepository<ContactRequestEntity, Long> {
    List<ContactRequestEntity> findByNombreContainingIgnoreCase(String nombre);

    List<ContactRequestEntity> findByFinalidad(ContactPurpose finalidad);

    List<ContactRequestEntity> findByLeidoFalse();

    List<ContactRequestEntity> findByAtendidoFalse();

    @Query("""
            SELECT c FROM ContactRequestEntity c
            WHERE (:nombre IS NULL OR :nombre = '' OR
            LOWER(c.nombre) LIKE LOWER(CONCAT('%', :nombre, '%')))
            AND (:correo IS NULL OR :correo = '' OR
            LOWER(c.correo) LIKE LOWER(CONCAT('%', :correo, '%')))
            AND (:finalidad IS NULL OR c.finalidad = :finalidad)
            AND (:leido IS NULL OR c.leido = :leido)
            AND (:atendido IS NULL OR c.atendido = :atendido)
            AND (:id IS NULL OR c.id = :id)
            """)
    List<ContactRequestEntity> filterContactRequests(
            @Param("nombre") String nombre,
            @Param("correo") String correo,
            @Param("finalidad") ContactPurpose finalidad,
            @Param("leido") Boolean leido,
            @Param("atendido") Boolean atendido,
            @Param("id") Long id
    );
}
